package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Customer;
import com.project.billing_service.DTOs.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable String id);

    // USING  HATEOS FOR GETTING LIST OF THE PRODUCTS
    @GetMapping("/api/products")
    PagedModel<Product> getAllProducts();
}
