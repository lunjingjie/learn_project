package com.learn.vo;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserVo implements Serializable{

    public interface UserQueryView {};

    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String userPassword;
    @ApiModelProperty("权限ID")
    private int roleId;
    @ApiModelProperty("用户ID")
    private int userId;

    public UserVo() {
    }

    public UserVo(String userName, String userPassword, int roleId, int userId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.roleId = roleId;
        this.userId = userId;
    }

    @JsonView(UserQueryView.class)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @JsonView(UserQueryView.class)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
