package com.food_delivery_backend.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalAmount;
    private String status;
    private String paymentStatus;
    private String paymentMethod;
    private LocalDateTime orderTime;
    private String deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
