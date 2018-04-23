package com.learn.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.model.HistoryModel;
import com.learn.service.HistoryDataService;
import com.learn.vo.MessageVo;
import com.learn.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("web/history")
@Api(tags = "历史数据")
public class HistoryDataController {

    private final HistoryDataService historyDataService;

    @Autowired
    public HistoryDataController(HistoryDataService historyDataService) {
        this.historyDataService = historyDataService;
    }

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "查询历史数据", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo loadAllUser(@RequestParam String enterpriseCode, @RequestParam Timestamp startTime, @RequestParam Timestamp endTime) {
        List<HashMap<String, Object>> result = historyDataService.loadHistoryData(enterpriseCode, startTime, endTime);
        return new MessageVo("200", "success", result);
    }
}
