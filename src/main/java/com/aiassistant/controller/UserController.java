package com.aiassistant.controller;

import com.aiassistant.model.User;
import com.aiassistant.service.UserService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResultModel<User> addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{userId}")
    public ResultModel<User> getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update")
    public ResultModel<User> updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResultModel<User> deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping("/changePassword")
    public ResultModel<User> changePassword(@Valid @RequestBody User user) {
        return userService.changePassword(user);
    }

    @PostMapping("/changePhoneNumber")
    public ResultModel<User> changePhoneNumber(@Valid @RequestBody User user) {
        return userService.changePhoneNumber(user);
    }
}
