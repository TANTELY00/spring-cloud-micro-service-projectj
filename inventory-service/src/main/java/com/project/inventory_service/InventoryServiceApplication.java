package com.project.inventory_service;

import com.project.inventory_service.entities.Product;
import com.project.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("computer")
					.price(2000)
					.quantity(20)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("printer")
					.price(2000)
					.quantity(20)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("smart phone")
					.price(2000)
					.quantity(20)
					.build());

			productRepository.findAll().forEach(products -> {
				System.out.println(products.toString());
			});
		};
	}
}
