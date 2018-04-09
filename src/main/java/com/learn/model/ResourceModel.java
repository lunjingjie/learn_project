package com.learn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "resource", schema = "strutssshlearn", catalog = "")
public class ResourceModel {
    private int resourceId;
    private String resourceName;
    private String resourcePath;
    private String resourceIcon;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String isDeleted;
    private int pid;
    private Collection<RoleResourceModel> roleResourcesByResourceId;

    @Id
    @Column(name = "resource_id")
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "resource_name")
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "resource_path")
    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Basic
    @Column(name = "resource_icon")
    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
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
    @Column(name = "is_deleted")
    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @OneToMany(mappedBy = "resourceByResourceId")
    public Collection<RoleResourceModel> getRoleResourcesByResourceId() {
        return roleResourcesByResourceId;
    }

    public void setRoleResourcesByResourceId(Collection<RoleResourceModel> roleResourcesByResourceId) {
        this.roleResourcesByResourceId = roleResourcesByResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceModel that = (ResourceModel) o;

        if (resourceId != that.resourceId) return false;
        if (pid != that.pid) return false;
        if (resourceName != null ? !resourceName.equals(that.resourceName) : that.resourceName != null) return false;
        if (resourcePath != null ? !resourcePath.equals(that.resourcePath) : that.resourcePath != null) return false;
        if (resourceIcon != null ? !resourceIcon.equals(that.resourceIcon) : that.resourceIcon != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId;
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourcePath != null ? resourcePath.hashCode() : 0);
        result = 31 * result + (resourceIcon != null ? resourceIcon.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + pid;
        return result;
    }
}
