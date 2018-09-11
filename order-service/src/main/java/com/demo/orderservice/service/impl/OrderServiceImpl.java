package com.demo.orderservice.service.impl;

import com.demo.orderservice.model.Order;
import com.demo.orderservice.repository.OrdersRepository;
import com.demo.orderservice.service.OrderService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public List<Order> getAllOrdersByUserId(String userId) {
        List<Order> result = new ArrayList<>();
        List<com.demo.orderservice.entities.Order> listOfOrderEntity = ordersRepository.findByUserId(userId);
        result = convertListOfOrderEntityToModel(listOfOrderEntity);
        return result;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> result = new ArrayList<>();
        List<com.demo.orderservice.entities.Order> listOfOrders = ordersRepository.findAll();
        result = convertListOfOrderEntityToModel(listOfOrders);
        return result;
    }

    @Override
    public Order addOrderByUser(Order order) {
        Order result = null;
        com.demo.orderservice.entities.Order resultInter = ordersRepository.save(convertOrderModelToEntity(order));
        result = convertOrderEntityToModel(resultInter);
        return result;
    }

    @Override
    public void deleteOrderById(Order order) {
        ordersRepository.delete(convertOrderModelToEntity(order));
    }

    private List<Order> convertListOfOrderEntityToModel(List<com.demo.orderservice.entities.Order> orders) {
        List<Order> result = new ArrayList<>();
        mapperFactory.classMap(com.demo.orderservice.entities.Order.class, Order.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        if (orders != null) {
            orders.forEach(order -> result.add(mapper.map(order, Order.class)));
        }
        return result;
    }

    private Order convertOrderEntityToModel(com.demo.orderservice.entities.Order order) {
        Order result = null;
        mapperFactory.classMap(com.demo.orderservice.entities.Order.class, Order.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        if (order != null) {
            result = mapper.map(order, Order.class);
        }
        return result;
    }

    private com.demo.orderservice.entities.Order convertOrderModelToEntity(Order order) {
        com.demo.orderservice.entities.Order result = null;
        mapperFactory.classMap(Order.class, com.demo.orderservice.entities.Order.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        if (order != null) {
            result = mapper.map(order, com.demo.orderservice.entities.Order.class);
        }
        return result;
    }
}
