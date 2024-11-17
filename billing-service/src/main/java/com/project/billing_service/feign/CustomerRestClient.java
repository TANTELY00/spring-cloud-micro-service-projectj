package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    // verifier si un costomer est existe
    @GetMapping("/api/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    // USING  HATEOS FOR GETTING LIST OF THE CUSTOMERS
    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();
}
