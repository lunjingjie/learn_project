package com.learn.controller;

import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ApiOperation(httpMethod = "POST", value = "创建一个用户对象", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createEditVo(@RequestBody UserVo userVo) {
        userService.saveUser(userVo);
    }

    @GetMapping
    @RequestMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "根据ID获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUserById(@ApiParam("用户ID") @PathVariable int id) {
        userService.getUserById(id);
    }
}
