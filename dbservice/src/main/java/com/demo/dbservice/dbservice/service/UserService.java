package com.demo.dbservice.dbservice.service;

import com.demo.dbservice.dbservice.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String userId);

    User addUser(User user);
}
