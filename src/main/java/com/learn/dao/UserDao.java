package com.learn.dao;

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

    public List<UserVo> getUser() {
        String sql = "select id as userId, userName, userPassword, role_id as roleId from user where isDeleted = 'N'";
        SQLQuery sq = (SQLQuery) getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserVo.class));
        sq.addScalar("userId", StandardBasicTypes.INTEGER);
        sq.addScalar("userName", StandardBasicTypes.STRING);
        sq.addScalar("userPassword", StandardBasicTypes.STRING);
        sq.addScalar("roleId", StandardBasicTypes.INTEGER);
        return sq.list();
    }

    public UserModel getUserById(int id) {
        return (UserModel) this.getSession().createQuery("from UserModel where id = ?")
                .setParameter(0, id).uniqueResult();
    }

    public void updateUser(UserModel user) {
        getSession().update(user);
    }

    public void deleteUser(UserModel user) {
        getSession().update(user);
    }
}
