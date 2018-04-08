package com.learn.dao;

import com.learn.model.UserModel;
import com.learn.vo.UserVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveUser(UserModel user) {
        this.getSession().save(user);
    }

    public List<UserModel> getUser() {
        return this.getSession().createCriteria(UserModel.class).list();
    }

    public UserModel getUserById(int id) {
        return (UserModel) this.getSession().createQuery("from UserModel where id = ?")
                .setParameter(0, id).uniqueResult();
    }

    public void updateUser() {
        this.getSession().createQuery("update UserModel set userName = 'abc' where id = 4").executeUpdate();
    }

    public void deleteUserById(int id) {
        this.getSession().createQuery("delete UserModel where id = ?")
                .setParameter(0, id).executeUpdate();
    }
}
