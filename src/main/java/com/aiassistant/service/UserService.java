package com.aiassistant.service;

import com.aiassistant.model.UserModel;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserModel> queryAll();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    UserModel addUser(UserModel user);

    /**
     * 根据用户ID查询用户
     *
     * @param id
     * @return
     */
    UserModel getUserById(Integer id);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    UserModel updateUser(UserModel user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Integer id);
}
