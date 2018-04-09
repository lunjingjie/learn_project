package com.learn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "strutssshlearn", catalog = "")
public class RoleModel {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String isDeleted;
    private Collection<RoleResourceModel> roleResourcesByRoleId;
    private Collection<UserModel> usersByRoleId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleModel roleModel = (RoleModel) o;

        if (roleId != roleModel.roleId) return false;
        if (roleName != null ? !roleName.equals(roleModel.roleName) : roleModel.roleName != null) return false;
        if (roleDesc != null ? !roleDesc.equals(roleModel.roleDesc) : roleModel.roleDesc != null) return false;
        if (insertTime != null ? !insertTime.equals(roleModel.insertTime) : roleModel.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(roleModel.updateTime) : roleModel.updateTime != null) return false;
        if (isDeleted != null ? !isDeleted.equals(roleModel.isDeleted) : roleModel.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }
}
