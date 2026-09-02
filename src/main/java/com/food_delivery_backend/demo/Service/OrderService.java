package com.food_delivery_backend.demo.Service;

import com.food_delivery_backend.demo.Entity.Order;
import com.food_delivery_backend.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public Order addOrder(Order order) {
       return repository.save(order);
    }
    public Order getOrderById(Long id) {
        return repository.findById(id) .orElseThrow(() -> new RuntimeException("Order not found"));
    }
    public List<Order> getOrdersByUser(Long userId) {
        return repository.findByUserId(userId);
    }
    public List<Order> getAllOrder() {
        return repository.findAll();
    }
}
