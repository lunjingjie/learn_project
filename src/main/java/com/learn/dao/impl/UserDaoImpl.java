package com.learn.dao.impl;

import com.learn.dao.UserDao;
import com.learn.model.UserModel;
import com.learn.vo.UserVo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lunjingjie
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveUser(UserModel user) {
        this.getSession().save(user);
    }

    @Override
    public List<UserVo> getUser() {
        String sql = "select id as userId, userName, userPassword, role_id as roleId from user where isDeleted = 'N'";
        SQLQuery sq = (SQLQuery) getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserVo.class));
        sq.addScalar("userId", StandardBasicTypes.INTEGER);
        sq.addScalar("userName", StandardBasicTypes.STRING);
        sq.addScalar("userPassword", StandardBasicTypes.STRING);
        sq.addScalar("roleId", StandardBasicTypes.INTEGER);
        return sq.list();
    }

    @Override
    public UserModel getUserById(int id) {
        return (UserModel) this.getSession().createQuery("from UserModel where id = ?")
                .setParameter(0, id).uniqueResult();
    }

    @Override
    public void updateUser(UserModel user) {
        getSession().update(user);
    }

    @Override
    public void deleteUser(UserModel user) {
        getSession().update(user);
    }

    @Override
    public UserModel getUserByName(String username) {
        return (UserModel) this.getSession().createQuery("from UserModel where userName = ?")
                .setParameter(0, username).uniqueResult();
    }
}
