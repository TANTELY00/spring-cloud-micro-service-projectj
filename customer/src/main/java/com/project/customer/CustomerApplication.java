package com.project.customer;

import com.project.customer.entite.Customer;
import com.project.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	// init database
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
                            .name("Tantely")
                            .email("tantelyravoson2019@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("James")
                    .email("james@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Jane")
                    .email("jane@gmail.com")
                    .build());

			customerRepository.findAll().forEach(customer -> {
				System.out.println("===================");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
				System.out.println("===================");
			});
		};
	}
}
