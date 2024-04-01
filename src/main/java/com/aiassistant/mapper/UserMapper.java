package com.aiassistant.mapper;

import com.aiassistant.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("INSERT INTO user(username, password) VALUES(#{user.username}, #{user.password})")
    User insertUser(@Param("user") User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(@Param("username") String username);
}
