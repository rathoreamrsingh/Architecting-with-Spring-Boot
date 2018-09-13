package com.demo.userservice.service.impl;


import com.demo.userservice.model.LoginDetail;
import com.demo.userservice.model.Order;
import com.demo.userservice.model.User;
import com.demo.userservice.model.UserWithOrder;
import com.demo.userservice.repository.UserRepository;
import com.demo.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.discovery.converters.Auto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.tools.jstat.ParserException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Override
    public List<User> getAllUsers() {
        List<User> listOfUsersResult = new ArrayList<>();
        List<com.demo.userservice.entities.User> listOfUserEntities = userRepository.findAll();
        mapperFactory.classMap(com.demo.userservice.entities.User.class, User.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        if (listOfUserEntities != null) {
            listOfUserEntities.forEach(userEntity -> listOfUsersResult.add(mapper.map(userEntity, User.class)));
        }
        return listOfUsersResult;
    }

    @Override
    public User getUserByUsername(String userId) {
        User user;
        mapperFactory.classMap(com.demo.userservice.entities.User.class, User.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        com.demo.userservice.entities.User userDetail = userRepository.findByuserid(userId);
        user = mapper.map(userDetail, User.class);
        return user;
    }

    @Override
    public User addUser(User user) {
        User result;
        mapperFactory.classMap(User.class, com.demo.userservice.entities.User.class).byDefault();
        MapperFacade mapperModelToEntity = mapperFactory.getMapperFacade();
        com.demo.userservice.entities.User resultAfterSave = userRepository.save(mapperModelToEntity.map(user, com.demo.userservice.entities.User.class));
        mapperFactory.classMap(com.demo.userservice.entities.User.class, User.class).byDefault();
        MapperFacade mapperEntityToModel = mapperFactory.getMapperFacade();
        result = mapperEntityToModel.map(resultAfterSave, User.class);
        return result;
    }

    @Override
    public UserWithOrder getUserWithUser(String username) {
        UserWithOrder result = new UserWithOrder();
        List<Order> listOfOrders = new ArrayList<>();
        result.setUser(this.getUserByUsername(username));
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<List<String>> quoteResponse = (ResponseEntity)restTemplate.getForEntity("http://ORDER-SERVICE/order/getAllOrdersByUserId/" + username, String.class);
        JSONParser parser = new JSONParser();
        try {
            JsonArray jsonArray = (JsonArray) parser.parse(quoteResponse.getBody().toString());
            Iterator arrayIterator = jsonArray.iterator();
            while(arrayIterator.hasNext()) {
                JsonObject jsonObject = (JsonObject)arrayIterator.next();
                Gson gson=new Gson();
                Order order = gson.fromJson(jsonObject.toString(), Order.class);
                listOfOrders.add(order);
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        result.setOrders(listOfOrders);
        return result;
    }

    @Override
    public Boolean login(LoginDetail loginDetail) {
        Boolean result = false;
        com.demo.userservice.entities.User u = userRepository.findByUseridAndPassword(loginDetail.getUsername(), loginDetail.getPassword());
        if(u != null) {
            result = true;
        }
        return result;
    }
}
