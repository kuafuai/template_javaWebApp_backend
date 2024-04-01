package com.aiassistant.controller;

import com.aiassistant.service.UserService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResultModel<User> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultModel<User> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return userService.login(username, password);
    }
}
