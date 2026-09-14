package com.food_delivery_backend.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cart")
    @JsonIgnore
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private int quantity;
    private double price;
}
