package com.aiassistant.service.impl;

import com.aiassistant.mapper.UserMapper;
import com.aiassistant.model.User;
import com.aiassistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public boolean loginUser(String jobNumber) {
        User user = userMapper.getUserByJobNumber(jobNumber);
        return user != null;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}