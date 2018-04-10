package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lunjingjie
 */
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(UserModel user) {
        userDao.saveUser(user);
    }

    @Override
    public List<UserVo> getUser() {
        return userDao.getUser();
    }

    @Override
    public UserModel getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(UserModel user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(UserModel user) {
        userDao.deleteUser(user);
    }
}
