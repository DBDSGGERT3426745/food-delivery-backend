package com.food_delivery_backend.demo.Controller;
import com.food_delivery_backend.demo.Entity.User;
import com.food_delivery_backend.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userservice.registerUser(user);
    }
    @GetMapping public List<User> getAllUsers() {
        return userservice.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userservice.getUserById(id);
    }
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userservice.getUserByEmail(email);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userservice.deleteUser(id); }
}
