package com.aiassistant.controller;

import com.aiassistant.model.User;
import com.aiassistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
        // Check if there are any validation errors
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // Check if job number already exists
        User existingUser = userService.getUserByJobNumber(user.getJobNumber());
        if (existingUser != null) {
            return new ResponseEntity<>("Duplicate job number", HttpStatus.BAD_REQUEST);
        }

        // Save user to database
        userService.registerUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody String jobNumber) {
        // Check if job number is empty or null
        if (jobNumber == null || jobNumber.isEmpty()) {
            return new ResponseEntity<>("Job number is required", HttpStatus.BAD_REQUEST);
        }

        // Get user by job number
        User user = userService.getUserByJobNumber(jobNumber);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Validate user information
        // ...

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user, BindingResult result) {
        // Check if there are any validation errors
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // Check if user exists in the database
        User existingUser = userService.getUserByJobNumber(user.getJobNumber());
        if (existingUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Update user information in database
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}