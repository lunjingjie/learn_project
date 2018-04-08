package com.learn.service;

import com.learn.dao.UserDao;
import com.learn.model.UserModel;
import com.learn.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(UserVo user) {
        userDao.saveUser(user);
    }

    public List<UserModel> getUser() {
        return userDao.getUser();
    }

    public UserModel getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void updateUser(UserModel user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

}