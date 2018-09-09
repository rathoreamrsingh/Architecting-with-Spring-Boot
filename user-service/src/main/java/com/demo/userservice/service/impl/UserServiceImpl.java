package com.demo.userservice.service.impl;

import com.demo.userservice.model.User;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<User> getAllUsers() {
        List<User> result = null;
        List<String> users = restTemplate.getForEntity("http://db-service/user/getAllUsers", List.class).getBody();
        return result;
    }
}
