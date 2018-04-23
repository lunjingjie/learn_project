package com.learn.service.impl;

import com.learn.dao.HistoryDataDao;
import com.learn.model.HistoryModel;
import com.learn.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author lunjingjie
 */
@Service
public class HistoryDataServiceImpl implements HistoryDataService {

    private final HistoryDataDao historyDataDao;

    @Autowired
    public HistoryDataServiceImpl(HistoryDataDao historyDataDao) {
        this.historyDataDao = historyDataDao;
    }

    @Override
    public List<HashMap<String, Object>> loadHistoryData(String enterpriseCode, Timestamp startTime, Timestamp endTime) {
        List<HistoryModel> historyDataList = historyDataDao.loadHistoryData(enterpriseCode, startTime, endTime);

        // 结果集中单个map集合
        Map<String, List<HistoryModel>> resultMap = new TreeMap<String, List<HistoryModel>>();
        for (HistoryModel historyData : historyDataList) {
            String datatime = historyData.getDatatime().toString();

            if (resultMap.containsKey(datatime)) {
                List<HistoryModel> historydatas = resultMap.get(datatime);
                historydatas.add(historyData);
            } else {
                List<HistoryModel> historydatas = new ArrayList<HistoryModel>();
                historydatas.add(historyData);
                resultMap.put(datatime, historydatas);
            }
        }

        HashMap<String, Object> tempMap;
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (String s : resultMap.keySet()) {
            tempMap = new HashMap<String, Object>();
            List<HistoryModel> historydatas = resultMap.get(s);
            tempMap.put("Datatime", s);

            for (HistoryModel historydata : historydatas) {
                String deviceName = historydata.getDeviceName();
                String unit = historydata.getDeviceByDeviceId().getDeviceUnit();
                String key = deviceName;
                if (unit != null && !"".equals(unit)) {
                    StringBuilder sb = new StringBuilder();
                    key = sb.append(deviceName).append("(").append(unit).append(")").toString();
                }
                String datavalue = historydata.getDataValue();
                tempMap.put(key, datavalue);
            }
            resultList.add(tempMap);
        }
        return resultList;
    }
}
