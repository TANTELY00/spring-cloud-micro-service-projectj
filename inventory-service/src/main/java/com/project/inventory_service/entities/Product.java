package com.project.inventory_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Product implements Serializable    {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
