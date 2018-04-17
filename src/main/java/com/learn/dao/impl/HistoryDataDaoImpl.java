package com.learn.dao.impl;

import com.learn.dao.HistoryDataDao;
import com.learn.model.HistoryModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class HistoryDataDaoImpl implements HistoryDataDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<HistoryModel> loadHistoryData(String enterpriseCode, Timestamp startTime, Timestamp endTime) {
        String hql = "from HistoryModel where deviceByDeviceId.mn = ?";
        Query sq = getSession().createQuery(hql).setString(0, enterpriseCode);
        return sq.list();
    }
}
