package com.aiassistant.controller;

import com.aiassistant.model.User;
import com.aiassistant.service.UserService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResultModel<User> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultModel<User> login(String username, String password) {
        return userService.login(username, password);
    }

    @PostMapping("/updateUserInfo")
    public ResultModel<User> updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @PostMapping("/updateUserRole")
    public ResultModel<User> updateUserRole(Integer userId, Integer roleId) {
        return userService.updateUserRole(userId, roleId);
    }
}
