package com.project.customer.entite;

import org.springframework.data.rest.core.config.Projection;

// PROJECTION IS  : for specify the attrib for view => for example just view "email"
// URL : http://localhost:8081/customers/1?projection=all
@Projection(name = "all" , types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getEmail();
}
