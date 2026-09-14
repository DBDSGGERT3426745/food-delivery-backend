package com.food_delivery_backend.demo.Controller;

import com.food_delivery_backend.demo.Entity.CartItem;
import com.food_delivery_backend.demo.Entity.Food;
import com.food_delivery_backend.demo.Payload.CartItemRequest;
import com.food_delivery_backend.demo.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/users/{userId}/cart-items")
    public ResponseEntity<CartItem> addFood(@RequestBody CartItemRequest request, @PathVariable Long userId){
           CartItem savedCartItem =cartItemService.addFood(request.getFoodId(),userId,request.getQuantity());
           return new ResponseEntity<>(savedCartItem, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/cart-items")
    public ResponseEntity<List<CartItem>> getUserItem(@PathVariable Long userId){
        List<CartItem> cartItem=cartItemService.getUserItem(userId);

        return new ResponseEntity<>(cartItem,HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/cart-items/{itemId}")
    public ResponseEntity<CartItem> deleteOneItem(@PathVariable Long userId,@PathVariable Long itemId){
        CartItem cartItem=cartItemService.deleteOneItem(userId,itemId);
        return new ResponseEntity<>(cartItem,HttpStatus.OK);
     }
     @DeleteMapping("/users/{userId}/cart-items")
    public ResponseEntity<String> clearCart(@PathVariable Long userId){
        String message=cartItemService.clearCart(userId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
