package com.learn.service;

import com.learn.model.UserModel;
import com.learn.vo.UserVo;

import java.util.List;

/**
 * @author lunjingjie
 */
public interface UserService {

    /**
     * 创建一个用户
     * @param user user
     */
    void saveUser(UserModel user);

    /**
     * 获取所有用户集合
     * @return userVo集合
     */
    List<UserVo> getUser();

    /**
     * 根据id获取用户信息
     * @param id id
     * @return 一个用户信息
     */
    UserModel getUserById(int id);

    /**
     * 更新一个用户
     * @param user user
     */
    void updateUser(UserModel user);

    /**
     * 软删除一个用户
     * @param user user
     */
    void deleteUser(UserModel user);

    UserModel getUserByName(String username, String password);
}
