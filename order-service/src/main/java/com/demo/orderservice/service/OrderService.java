package com.demo.orderservice.service;

import com.demo.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrdersByUserId(String userId);

    List<Order> getAllOrders();

    Order addOrderByUser(Order order);

    void deleteOrderById(Order order);
}
