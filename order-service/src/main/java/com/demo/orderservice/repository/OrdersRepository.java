package com.demo.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.orderservice.entities.*;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(String userid);
}
