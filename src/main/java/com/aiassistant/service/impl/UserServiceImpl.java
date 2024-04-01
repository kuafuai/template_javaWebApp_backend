package com.aiassistant.service.impl;

import com.aiassistant.mapper.UserMapper;
import com.aiassistant.model.User;
import com.aiassistant.service.UserService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ResultModel<User> register(User user) {
        // TODO: Implement user registration logic
        return null;
    }

    @Override
    public ResultModel<User> login(String username, String password) {
        // TODO: Implement user login logic
        return null;
    }
}
