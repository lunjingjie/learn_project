package com.learn.model;

import javax.persistence.*;

@Entity
@Table(name = "role_resource", schema = "strutssshlearn")
public class RoleResourceModel {
    private int id;
    private RoleModel roleByRoleId;
    private ResourceModel resourceByResourceId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    public RoleModel getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleModel roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", nullable = false)
    public ResourceModel getResourceByResourceId() {
        return resourceByResourceId;
    }

    public void setResourceByResourceId(ResourceModel resourceByResourceId) {
        this.resourceByResourceId = resourceByResourceId;
    }
}
