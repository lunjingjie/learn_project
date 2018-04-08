package com.learn.vo;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

public class UserVo {

    public interface UserQueryView {};

    @ApiModelProperty("用户ID")
    private int id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String userPassword;

    public UserVo() {
    }

    public UserVo(int id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @JsonView(UserQueryView.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonView(UserQueryView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
