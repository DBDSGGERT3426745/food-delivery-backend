package com.food_delivery_backend.demo.Controller;

import com.food_delivery_backend.demo.Entity.Order;
import com.food_delivery_backend.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }
    @GetMapping public List<Order> getAllOrders() {
        return service.getAllOrder();
    }

}
