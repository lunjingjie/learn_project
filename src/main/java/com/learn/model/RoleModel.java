package com.learn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "strutssshlearn")
public class RoleModel {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String isDeleted;
    private Collection<RoleResourceModel> roleResourcesByRoleId;
    private Collection<UserModel> usersByRoleId;

    public RoleModel() {
    }

    public RoleModel(int roleId) {
        this.roleId = roleId;
    }

    public RoleModel(int roleId, String roleName, String roleDesc, Timestamp insertTime, Timestamp updateTime, String isDeleted, Collection<RoleResourceModel> roleResourcesByRoleId, Collection<UserModel> usersByRoleId) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.isDeleted = isDeleted;
        this.roleResourcesByRoleId = roleResourcesByRoleId;
        this.usersByRoleId = usersByRoleId;
    }

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_desc")
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Basic
    @Column(name = "insertTime")
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "is_deleted")
    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleResourceModel> getRoleResourcesByRoleId() {
        return roleResourcesByRoleId;
    }

    public void setRoleResourcesByRoleId(Collection<RoleResourceModel> roleResourcesByRoleId) {
        this.roleResourcesByRoleId = roleResourcesByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserModel> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Collection<UserModel> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
