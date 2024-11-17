package com.project.billing_service.repository;

import com.project.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<Bill,Long> {
}
