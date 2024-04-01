package com.aiassistant.mapper;

import com.aiassistant.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectByUsernameAndPasswordAndRole(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
