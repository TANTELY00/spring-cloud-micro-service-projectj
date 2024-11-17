package com.project.billing_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.billing_service.DTOs.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // pour afficher 1 productItem dans l'affichage de bill pour eviter la boucle infinie
    private Bill bill;
    private int quantity;
    private double unitPrice;
    @Transient private Product product;
}
