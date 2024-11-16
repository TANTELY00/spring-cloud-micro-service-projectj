package com.project.customer.repository;

import com.project.customer.entite.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource // for the methods at this repository CRUD
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
