package com.food_delivery_backend.demo.Service;

import com.food_delivery_backend.demo.Entity.Cart;
import com.food_delivery_backend.demo.Entity.User;
import com.food_delivery_backend.demo.Exceptions.ResourceNotFoundException;
import com.food_delivery_backend.demo.Repository.CartRepository;
import com.food_delivery_backend.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    public Cart getUserCart(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Cart carts=user.getCart();
        return carts;
    }

    public Cart clearCart(Long userId) {
        Cart cart= cartRepository.findByUser_Id(userId)
                        .orElseThrow(()->new ResourceNotFoundException("Cart","userId",userId));
        cart.getItemList().clear();
        return cart;
    }
}
