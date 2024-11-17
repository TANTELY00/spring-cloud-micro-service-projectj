package com.project.billing_service;

import com.project.billing_service.DTOs.Customer;
import com.project.billing_service.DTOs.Product;
import com.project.billing_service.entities.Bill;
import com.project.billing_service.entities.ProductItem;
import com.project.billing_service.feign.CustomerRestClient;
import com.project.billing_service.feign.ProductRestClient;
import com.project.billing_service.repository.BillRepository;
import com.project.billing_service.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients // pour activer Feign client
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository ,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient
										){

		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent(); // return collection de getContent car le données sont en formets PagedModel
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);

				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.bill(bill)
							.productId(product.getId())
							.quantity(1+new Random().nextInt(10)) // nombre entre 1 et 10
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});
			});
		};
	}
}
