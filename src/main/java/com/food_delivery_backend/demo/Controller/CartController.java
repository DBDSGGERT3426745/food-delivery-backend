package com.food_delivery_backend.demo.Controller;

import com.food_delivery_backend.demo.Entity.Cart;
import com.food_delivery_backend.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
   @Autowired
    CartService cartService;

    @GetMapping("/carts/{userId}")
    public ResponseEntity<Cart> getUserCart(@PathVariable Long userId){
         Cart cart=cartService.getUserCart(userId);
         return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @DeleteMapping("/carts/{userId}")
    public ResponseEntity<Cart> clearCart(@PathVariable Long userId){
        Cart cart=cartService.clearCart(userId);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
}
