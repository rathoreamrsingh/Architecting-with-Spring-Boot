package com.demo.userservice.service;


import com.demo.userservice.model.LoginDetail;
import com.demo.userservice.model.User;
import com.demo.userservice.model.UserWithOrder;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String userId);

    User addUser(User user);

    UserWithOrder getUserWithUser(String username);

    Boolean login(LoginDetail loginDetail);
}
