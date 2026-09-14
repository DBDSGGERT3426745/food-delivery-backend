package com.food_delivery_backend.demo.Service; import com.food_delivery_backend.demo.Entity.Cart;
import com.food_delivery_backend.demo.Entity.User;
import com.food_delivery_backend.demo.Repository.CartRepository;
import com.food_delivery_backend.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    public User registerUser(User user) {
        User savedUser=userRepository.save(user);
        Cart cart=new Cart();
        cart.setUser(savedUser);
        cart.setTotalAmount(0.0);
        cartRepository.save(cart);
        savedUser.setCart(cart);
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
