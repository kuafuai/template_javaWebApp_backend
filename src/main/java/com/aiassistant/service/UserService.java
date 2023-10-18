package com.aiassistant.service;

import com.aiassistant.model.User;
import com.aiassistant.utils.ResultModel;

public interface UserService {
    ResultModel<User> addUser(User user);

    ResultModel<User> getUserById(String userId);

    ResultModel<User> updateUser(User user);

    ResultModel<User> deleteUser(String userId);
}
