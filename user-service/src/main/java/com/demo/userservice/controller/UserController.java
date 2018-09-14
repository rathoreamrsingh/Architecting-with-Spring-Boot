package com.demo.userservice.controller;

import com.demo.userservice.model.LoginDetail;
import com.demo.userservice.model.User;
import com.demo.userservice.model.UserWithOrder;
import com.demo.userservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${message:Hello default}")
    private String message;

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

    @GetMapping("/getUserWithOrders/{username}")
    public UserWithOrder getUserWithOrders(@PathVariable(value = "username") String username) {
        UserWithOrder result;
        result = userService.getUserWithUser(username);
        return result;
    }

    @GetMapping("/getUserWithOrdersWithHystix/{username}")
    @HystrixCommand(groupKey = "getUserWithOrder", commandKey = "getUserWithOrder", fallbackMethod = "fallback")
    public UserWithOrder getUserWithOrdersWithHystix(@PathVariable(value = "username") String username) {
        UserWithOrder result;
        result = userService.getUserWithUser(username);
        return result;
    }

    public UserWithOrder fallback(@PathVariable(value = "username") String username) {
        UserWithOrder result = new UserWithOrder();
        User u = userService.getUserByUsername(username);
        result.setUser(u);
        return result;
    }
    @PostMapping("/login")
    public Boolean login(@RequestBody LoginDetail loginDetail) {
        Boolean result;
        result = userService.login(loginDetail);
        return result;
    }

    @GetMapping("/getEnvData")
    public String getEnvData() {
        return this.message;
    }
}
