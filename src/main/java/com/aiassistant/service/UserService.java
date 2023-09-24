package com.aiassistant.service;

import com.aiassistant.model.User;

public interface UserService {
    int registerUser(User user);
    boolean loginUser(String jobNumber);
    int updateUser(User user);
}