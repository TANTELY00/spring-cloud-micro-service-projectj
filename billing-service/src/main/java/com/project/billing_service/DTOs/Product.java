package com.project.billing_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
