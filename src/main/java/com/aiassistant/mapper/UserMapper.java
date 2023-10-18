package com.aiassistant.mapper;

import com.aiassistant.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User insertUser(User user);

    List<User> getUserList();

    User selectById(String userId);
}
