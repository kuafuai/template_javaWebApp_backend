package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.User;

public interface LoginService {
    ResultModel<User> login(String username, String password, String role);
}
