package com.food_delivery_backend.demo.Controller;

import com.food_delivery_backend.demo.Entity.Food;
import com.food_delivery_backend.demo.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/foods")
    public ResponseEntity<List<Food>> getAllFoods(){
        List<Food> food =foodService.getAllFoods();
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
    @PostMapping("/foods")
    public ResponseEntity<Food> createFood(@RequestBody Food food ){
        Food foods=foodService.createFood(food);
        return new ResponseEntity<>(foods,HttpStatus.CREATED);
    }
    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id){
        Food food=foodService.getFoodById(id);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }

    @PutMapping("/foods/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id,@RequestBody Food food){
        Food foods=foodService.updateFood(id,food);
        return new ResponseEntity<>(foods,HttpStatus.OK);
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable Long id){
        Food food=foodService.deleteFood(id);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }

    @GetMapping("/foods/available")
    public ResponseEntity<List<Food>> available(){
        List<Food> availableFood=foodService.availableFood();
        return new ResponseEntity<>(availableFood,HttpStatus.OK);
    }

}
