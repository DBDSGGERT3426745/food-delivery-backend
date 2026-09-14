package com.food_delivery_backend.demo.Service;

import com.food_delivery_backend.demo.Entity.Cart;
import com.food_delivery_backend.demo.Entity.CartItem;
import com.food_delivery_backend.demo.Entity.Food;
import com.food_delivery_backend.demo.Entity.User;
import com.food_delivery_backend.demo.Exceptions.ResourceNotFoundException;
import com.food_delivery_backend.demo.Repository.CartItemRepository;
import com.food_delivery_backend.demo.Repository.CartRepository;
import com.food_delivery_backend.demo.Repository.FoodRepository;
import com.food_delivery_backend.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    public CartItem addFood(Long foodId, Long userId, int quantity) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Cart cart=user.getCart();
        Food food=foodRepository.findById(foodId)
                .orElseThrow(()->new ResourceNotFoundException("Food","foodId",foodId));
        CartItem cartItem=new CartItem();
        cartItem.setCart(cart);
        cartItem.setFood(food);
        cartItem.setQuantity(quantity);
        cart.
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getUserItem(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Cart cart=user.getCart();
        return cart.getItemList();
    }


    public CartItem deleteOneItem(Long userId, Long itemId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Cart cart=user.getCart();
        CartItem cartItem=cartItemRepository
                .findByIdAndCartId(cart.getId(),itemId)
                .orElseThrow(()->new ResourceNotFoundException("CartItem","itemId",itemId));
        cartItemRepository.delete(cartItem);
        return cartItem;
    }

    public String clearCart(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Cart cart=user.getCart();
        cart.getItemList().clear();
        cartRepository.save(cart);
        return "Users cart is cleared";
    }
}
