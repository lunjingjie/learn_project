package com.learn.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.vo.MessageVo;
import com.learn.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户信息管理")
public class UserController {

    @Autowired
    private UserService userService;

    private MessageVo messageVo = new MessageVo();

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "查询所有用户角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(UserVo.UserQueryView.class)
    public List<UserVo> loadAllUser() {
        List<UserModel> resList = userService.getUser();
        List<UserVo> userList = new ArrayList<UserVo>();
        for (UserModel user : resList) {
            UserVo userVo = new UserVo();
            userVo.setUserName(user.getUserName());
            userVo.setRoleId(user.getRoleByRoleId().getRoleId());
            userVo.setUserId(user.getId());
            userList.add(userVo);
        }
        return userList;
    }

    @PostMapping
    @ApiOperation(httpMethod = "POST", value = "创建一个用户对象", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo createEditVo(UserVo userVo) {
        String username = userVo.getUserName();
        String password = DigestUtils.md5Hex(userVo.getUserPassword());
        UserModel user = new UserModel();
        user.setUserName(username);
        user.setUserPassword(DigestUtils.md5Hex(password));
        userService.saveUser(user);
        messageVo.setResult("创建成功");
        return messageVo;
    }

    @GetMapping
    @RequestMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "根据ID获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUserById(@ApiParam("用户ID") @PathVariable int id) {
        userService.getUserById(id);
    }

    @PutMapping
    @ApiOperation(httpMethod = "PUT", value = "更新某个用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserById() {
        userService.updateUser();
    }
}
