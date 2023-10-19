package com.aiassistant.service.impl;

import com.aiassistant.mapper.UserMapper;
import com.aiassistant.model.User;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public ResultModel<User> addUser(User user) {
        int count = userMapper.addUser(user);
        if (count > 0) {
            return ResultModel.ofSuccess(user);
        } else {
            return ResultModel.ofError("Failed to add user");
        }
    }

    public ResultModel<User> getUserById(String userId) {
        if (userId == null || userId.isEmpty()) {
            return ResultModel.ofError("Invalid userId");
        }
        User user = userMapper.getUserById(userId);
        if (user != null) {
            return ResultModel.ofSuccess(user);
        } else {
            return ResultModel.ofError("User not found");
        }
    }

    public ResultModel<User> updateUser(User user) {
        int count = userMapper.updateUser(user);
        if (count > 0) {
            return ResultModel.ofSuccess(user);
        } else {
            return ResultModel.ofError("Failed to update user");
        }
    }

    public ResultModel<User> deleteUser(String userId) {
        int count = userMapper.deleteUser(userId);
        if (count > 0) {
            return ResultModel.ofSuccess();
        } else {
            return ResultModel.ofError("Failed to delete user");
        }
    }

    public ResultModel<User> changePassword(String userId, String newPassword) {
        int count = userMapper.changePassword(userId, newPassword);
        if (count > 0) {
            return ResultModel.ofSuccess();
        } else {
            return ResultModel.ofError("Failed to change password");
        }
    }

    public ResultModel<User> changePhoneNumber(String userId, String newPhoneNumber) {
        int count = userMapper.changePhoneNumber(userId, newPhoneNumber);
        if (count > 0) {
            return ResultModel.ofSuccess();
        } else {
            return ResultModel.ofError("Failed to change phone number");
        }
    }
}
