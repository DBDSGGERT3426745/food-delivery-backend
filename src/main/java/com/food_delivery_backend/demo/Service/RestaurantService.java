package com.food_delivery_backend.demo.Service;
import com.food_delivery_backend.demo.Entity.Restaurant;

import com.food_delivery_backend.demo.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;
    public Restaurant addRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }
    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }
    public void deleteRestaurant(Long id) {
        repository.deleteById(id); }
    public List<Restaurant> getOpenRestaurants() {
        return repository.findByIsOpenTrue(); }
    public void deleteOrder(Long id) {
        repository.deleteById(id); }
}
