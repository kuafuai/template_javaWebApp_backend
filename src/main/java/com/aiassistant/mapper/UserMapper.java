package com.aiassistant.mapper;

import com.aiassistant.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser(User user);
    User selectByJobNumber(String jobNumber);
    int updateUser(User user);
}