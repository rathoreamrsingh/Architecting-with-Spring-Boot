package com.demo.userservice.service;


import com.demo.userservice.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String userId);

    User addUser(User user);
}
