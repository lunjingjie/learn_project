package com.learn.controller;

import com.learn.exception.UnauthorizedException;
import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.util.JWTUtil;
import com.learn.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("web/login")
@Api(tags = "登录操作")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(httpMethod = "POST", value = "登录", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageVo login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        UserModel userModel = userService.getUserByName(username);
        if (userModel.getUserPassword().equals(password)) {
            return new MessageVo(200, "success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }
}
