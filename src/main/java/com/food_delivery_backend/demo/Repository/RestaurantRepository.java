package com.food_delivery_backend.demo.Repository;

import com.food_delivery_backend.demo.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Optional<Restaurant> findByEmail(String Email);
    List<Restaurant> findByCityIgnoreCase(String city);
    List<Restaurant> findByIsOpenTrue();
    List<Restaurant> findByRatingGreaterThanEqual(Double rating);
}
