package com.food_delivery_backend.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phoneNumber;
    @OneToOne(mappedBy ="user")
    @JsonIgnore
    private Cart cart;


}
