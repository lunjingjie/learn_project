package com.learn.dao;

import com.learn.model.UserModel;
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

    @SuppressWarnings("unchecked")
    public List<UserModel> getUser() {
        return this.getSession().createCriteria(UserModel.class).list();
    }

    public UserModel getUserById(int id) {
        return (UserModel) this.getSession().createQuery("from UserModel where id = ?")
                .setParameter(0, id).uniqueResult();
    }

    public void updateUser(UserModel user) {
        this.getSession().update(user);
    }

    public void deleteUserById(int id) {
        this.getSession().createQuery("delete UserModel where id = ?")
                .setParameter(0, id).executeUpdate();
    }
}
