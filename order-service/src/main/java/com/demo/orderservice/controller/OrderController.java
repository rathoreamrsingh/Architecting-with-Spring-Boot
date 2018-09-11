package com.demo.orderservice.controller;

import com.demo.orderservice.model.Order;
import com.demo.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getListOfOrders() {
        List<Order> orders = null;
        orders = orderService.getAllOrders();
        return orders;
    }

    @GetMapping(value = "/getAllOrdersByUserId/{userid}")
    public List<Order> getAllOrdersByUserId(@PathVariable(value = "userid") String userId) {
        List<Order> orders = null;
        orders = orderService.getAllOrdersByUserId(userId);
        return orders;
    }

    @PostMapping(value = "/addOrderByUser")
    public Order addOrderByUser(@RequestBody Order order) {
        Order result = new Order();
        result = orderService.addOrderByUser(order);
        return result;
    }

    @DeleteMapping(value = "/deleteOrder")
    public void deleteOrder(@RequestBody Order order) {
        orderService.deleteOrderById(order);
    }
}
