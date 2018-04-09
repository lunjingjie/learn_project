package com.learn.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "strutssshlearn")
public class UserModel {
    private int id;
    private String userName;
    private String userPassword;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String isDeleted;
    private RoleModel roleByRoleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "insert_time")
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "isDeleted")
    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    public RoleModel getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleModel roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
