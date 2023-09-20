package com.aiassistant.mapper;

import com.aiassistant.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 持久化层--用户Mapper
 */
@Mapper
public interface UserMapper {

    /**
     * 查询最新一条用户记录
     *
     * @return
     */
    Map<String, Object> selectOne();

    /**
     * 查询所有用户记录
     *
     * @return
     */
    List<UserModel> selectAll();

    /**
     * 插入用户记录
     *
     * @param user
     * @return
     */
    int insertUser(UserModel user);

    /**
     * 根据ID查询用户记录
     *
     * @param id
     * @return
     */
    UserModel selectById(Integer id);

    /**
     * 更新用户记录
     *
     * @param user
     * @return
     */
    int updateUser(UserModel user);

    /**
     * 删除用户记录
     *
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}
