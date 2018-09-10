package com.demo.userservice.controller;

import com.demo.userservice.model.User;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        List<User> result;
        result = userService.getAllUsers();
        return result;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        User result;
        result = userService.addUser(user);
        return result;
    }
    @GetMapping("/getUserByUserName/{username}")
    public User getUserByUserName(@PathVariable(value = "username") String username) {
        User result;
        result = userService.getUserByUsername(username);
        return result;
    }
}
