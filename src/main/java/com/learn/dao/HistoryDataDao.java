package com.learn.dao;

import com.learn.model.HistoryModel;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author lunjingjie
 */
public interface HistoryDataDao {

    List<HistoryModel> loadHistoryData(String enterpriseCode, Timestamp startTime, Timestamp endTime);
}
