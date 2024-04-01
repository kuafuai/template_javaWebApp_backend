package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.User;

public interface UserService {
    ResultModel<User> register(User user);
    ResultModel<User> login(String username, String password);
}
