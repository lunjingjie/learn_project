package com.learn.controller;

import com.learn.model.UserModel;
import com.learn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户信息管理")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "查询所有用户角色", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> loadAllUser() {
        List<UserModel> resList = userService.getUser();
        return resList;
    }
}
