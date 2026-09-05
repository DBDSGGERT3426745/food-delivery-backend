package com.food_delivery_backend.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    private String city;
    @Column(unique = true)
    private String phone;
    @Column(unique = true,nullable = false)
    private String email;

    private Double rating;

    private Boolean isOpen;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Food> foods;

}
