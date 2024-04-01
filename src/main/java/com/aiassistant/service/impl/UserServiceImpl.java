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
        try {
            // 调用userMapper的insert方法将用户信息插入数据库
            userMapper.insert(user);
            return ResultModel.ofSuccess(user);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to register user", e);
        }
    }

    @Override
    public ResultModel<User> login(String username, String password) {
        try {
            // 调用userMapper的selectByUsernameAndPassword方法查询用户信息
            User user = userMapper.selectByUsernameAndPassword(username, password);
            if (user != null) {
                return ResultModel.ofSuccess(user);
            } else {
                return ResultModel.ofError("Invalid username or password");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to login", e);
        }
    }

    @Override
    public ResultModel<User> updateUserInfo(User user) {
        try {
            // 调用userMapper的update方法更新用户信息
            userMapper.update(user);
            return ResultModel.ofSuccess(user);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update user info", e);
        }
    }

    @Override
    public ResultModel<User> updateUserRole(Integer userId, Integer roleId) {
        try {
            // 调用userMapper的updateUserRole方法更新用户角色
            userMapper.updateUserRole(userId, roleId);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update user role", e);
        }
    }
}
