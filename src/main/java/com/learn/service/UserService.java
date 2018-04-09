package com.learn.service;

import com.learn.dao.UserDao;
import com.learn.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(UserModel user) {
        userDao.saveUser(user);
    }

    public List<UserModel> getUser() {
        return userDao.getUser();
    }

    public UserModel getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void updateUser() {
        userDao.updateUser();
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
