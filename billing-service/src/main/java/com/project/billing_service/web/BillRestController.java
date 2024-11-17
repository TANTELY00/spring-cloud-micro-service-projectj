package com.project.billing_service.web;

import com.project.billing_service.entities.Bill;
import com.project.billing_service.feign.CustomerRestClient;
import com.project.billing_service.feign.ProductRestClient;
import com.project.billing_service.repository.BillRepository;
import com.project.billing_service.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;

    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping(path = "/bills/{id}")
    public Bill getBill( @PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId())); // contact customer service pour completer le nom du client
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}
