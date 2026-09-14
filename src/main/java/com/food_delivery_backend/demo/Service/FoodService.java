package com.food_delivery_backend.demo.Service;

import com.food_delivery_backend.demo.Entity.Food;
import com.food_delivery_backend.demo.Entity.Restaurant;
import com.food_delivery_backend.demo.Exceptions.APIException;
import com.food_delivery_backend.demo.Exceptions.ResourceNotFoundException;
import com.food_delivery_backend.demo.Repository.FoodRepository;
import com.food_delivery_backend.demo.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Food> getAllFoods() {
        List<Food> foods= foodRepository.findAll();
        if(foods.isEmpty()){
            throw new APIException("No Food created till now");
        }
        return foods;
    }

    public Food createFood(Food food) {
        Long restaurantId=food.getRestaurant().getId();
        Restaurant restaurant=restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new ResourceNotFoundException("Restaurant","Restaurant ID",restaurantId));
        food.setRestaurant(restaurant);
       return foodRepository.save(food);
    }

    public Food getFoodById(Long id) {
        Food food=foodRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Food","Food Id",id));
        return food;
    }

    public Food updateFood(Long id,Food food) {
        Food foods=foodRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Food","Food Id",id));
       foods.setName(food.getName());
       foods.setPrice(food.getPrice());
       foods.setDescription(food.getDescription());
       foods.setCategory(food.getCategory());
       foods.setAvailable(food.isAvailable());
       return foodRepository.save(foods);
    }

    public Food deleteFood(Long id) {
        Food food=foodRepository.findById(id)
                .orElseThrow(()->new  ResourceNotFoundException("Food","Food Id",id));
        foodRepository.delete(food);
        return food;
    }

    public List<Food> availableFood() {

        List<Food> foods= foodRepository.findByAvailableTrue();
        if(foods.isEmpty()){
            throw new APIException("No food available now");
        }
        return foods;
    }
}
