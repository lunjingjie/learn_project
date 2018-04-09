package com.learn.dao.impl;

import com.learn.dao.PageResourceDao;
import com.learn.vo.ResourceTree;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageResourceDaoImpl implements PageResourceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ResourceTree getParentNode(Integer roleId, Integer cId) {
        return null;
    }

    @Override
    public List<ResourceTree> getChildNode(Integer roleId, Integer cId) {
        return null;
    }

    @Override
    public ResourceTree getParentNode(Integer cId) {
        String sql = "select resource_id as id,resource_name as resourceName,resource_path as resourcePath,pid from resource where resource_id=?";
        //Transformers.aliasToBean把结果通过setter方法注入到指定的对象属性中
        SQLQuery sq = (SQLQuery) getSession().createSQLQuery(sql).setParameter(0, cId).setResultTransformer(Transformers.aliasToBean(ResourceTree.class));
        sq.addScalar("id", StandardBasicTypes.INTEGER);
        sq.addScalar("resourceName", StandardBasicTypes.STRING);
        sq.addScalar("resourcePath", StandardBasicTypes.STRING);
        sq.addScalar("pid", StandardBasicTypes.INTEGER);
        return (ResourceTree) sq.uniqueResult();
    }

    @Override
    public List<ResourceTree> getChildNode(Integer pId) {
        String sql = "select resource_id as id,resource_name as resourceName,resource_path resourcePath,pid from resource where pid=?";

        SQLQuery sq = (SQLQuery)getSession().createSQLQuery(sql)
                .setParameter(0, pId)
                .setResultTransformer(Transformers.aliasToBean(ResourceTree.class));

        sq.addScalar("id", StandardBasicTypes.INTEGER);
        sq.addScalar("resourceName", StandardBasicTypes.STRING);
        sq.addScalar("pid", StandardBasicTypes.INTEGER);
        sq.addScalar("resourcePath", StandardBasicTypes.STRING);

        return sq.list();
    }
}
