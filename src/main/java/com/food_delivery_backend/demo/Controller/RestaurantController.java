package com.food_delivery_backend.demo.Controller;

import com.food_delivery_backend.demo.Entity.Restaurant;
import com.food_delivery_backend.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService service;
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return service.addRestaurant(restaurant);
    }
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants();
    }
    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        service.deleteRestaurant(id);
        return "Restaurant deleted successfully"; }
    @GetMapping("/open")
    public List<Restaurant> getOpenRestaurants() {
        return service.getOpenRestaurants();
    }
}
