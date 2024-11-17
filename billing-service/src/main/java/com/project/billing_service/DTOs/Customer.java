package com.project.billing_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


// I need the details for the clients in the bill
@Getter @Setter
public class Customer implements Serializable {
    private Long id;
    private String name;
    private String email;

}
