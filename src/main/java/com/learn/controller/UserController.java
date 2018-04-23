package com.learn.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.model.RoleModel;
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

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("web/user")
@Api(tags = "用户信息管理")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "查询所有用户角色", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo loadAllUser() {
        List<UserVo> resList = userService.getUser();
        return new MessageVo("200", "success", resList);
    }

    @PostMapping
    @ApiOperation(httpMethod = "POST", value = "创建一个用户对象", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo createEditVo(UserVo userVo) {
        String username = userVo.getUserName();
        String password = userVo.getUserPassword();
        int roleId = userVo.getRoleId();
        UserModel user = new UserModel();
        RoleModel role = new RoleModel(roleId);
        user.setRoleByRoleId(role);
        user.setUserName(username);
        user.setUserPassword(password);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setInsertTime(now);
        user.setIsDeleted("N");
        userService.saveUser(user);
        return new MessageVo("200", "创建成功");
    }

    @GetMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "根据ID获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo getUserById(@ApiParam("用户ID") @PathVariable int id) {
        UserModel userModel = userService.getUserById(id);
        UserVo userVo = new UserVo();
        userVo.setUserName(userModel.getUserName());
        userVo.setRoleId(userModel.getRoleByRoleId().getRoleId());
        userVo.setUserId(userModel.getId());
        return new MessageVo("200", "success", userVo);
    }

    @PutMapping
    @ApiOperation(httpMethod = "PUT", value = "更新某个用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo updateUserById(UserVo userVo) {
        UserModel user = userService.getUserById(userVo.getUserId());

        if (userVo.getRoleId() != 0) {
            RoleModel role = new RoleModel(userVo.getRoleId());
            user.setRoleByRoleId(role);
        }
        if (userVo.getUserName() != "") {
            user.setUserName(userVo.getUserName());
        }
        if (userVo.getUserPassword() != "") {
            user.setUserPassword(DigestUtils.md5Hex(userVo.getUserPassword()));
        }
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setUpdateTime(now);
        userService.updateUser(user);
        return new MessageVo("200", "更新成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(httpMethod = "DELETE", value = "根据用户ID删除用户", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo deleteUserById(@PathVariable int id) {
        UserModel user = userService.getUserById(id);
        user.setIsDeleted("Y");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setUpdateTime(now);
        userService.deleteUser(user);
        return new MessageVo("200", "删除成功");
    }
}
