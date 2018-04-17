package com.learn.service;

import com.learn.model.HistoryModel;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface HistoryDataService {

    List<HashMap<String, Object>> loadHistoryData(String enterpriseCode, Timestamp startTime, Timestamp endTime);
}
