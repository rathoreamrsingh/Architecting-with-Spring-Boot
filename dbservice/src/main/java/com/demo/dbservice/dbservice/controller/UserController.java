package com.demo.dbservice.dbservice.controller;

import com.demo.dbservice.dbservice.model.User;
import com.demo.dbservice.dbservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        List<User> listOfUsers;
        listOfUsers = userService.getAllUsers();
        return listOfUsers;
    }

    @GetMapping("/getUserByUserId/{userId}")
    public User getUserByUsername(@PathVariable(name = "userId") String userId) {
        User user;
        user = userService.getUserByUsername(userId);
        return user;
    }

    @PostMapping("/saveUser")
    public User addUser(@RequestBody User user) {
        User result;
        result = userService.addUser(user);
        return result;
    }
}
