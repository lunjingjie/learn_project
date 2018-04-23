package com.learn.controller;

import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @author lunjingjie
 */
@RestController
@RequestMapping("/web/login")
@Api(tags = "登录接口")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "登录", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo login(@RequestParam String userName, @RequestParam String userPassword) {
        return new MessageVo("200", "登录成功");
    }
}
