package com.aiassistant.service.impl;

import com.aiassistant.mapper.UserMapper;
import com.aiassistant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // Implement methods from LoginService interface here

}
