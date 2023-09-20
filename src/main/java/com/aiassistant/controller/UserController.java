package com.aiassistant.controller;

import com.aiassistant.model.UserModel;
import com.aiassistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public UserModel addUser(@RequestParam String name, @RequestParam int age, @RequestParam String gender) {
        return userService.addUser(name, age, gender);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable int id, @RequestParam String name, @RequestParam int age, @RequestParam String gender) {
        return userService.updateUser(id, name, age, gender);
    }

    @DeleteMapping("/{id}")
    public UserModel deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
