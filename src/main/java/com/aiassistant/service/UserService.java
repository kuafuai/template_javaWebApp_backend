package com.aiassistant.service;

import com.aiassistant.model.User;
import com.aiassistant.utils.ResultModel;

public interface UserService {
    ResultModel<User> register(User user);

    ResultModel<User> login(String username, String password);

    ResultModel<User> updateUserInfo(User user);

    ResultModel<User> updateUserRole(Integer userId, Integer roleId);
}
