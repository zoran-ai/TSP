package com.chawran.common.mybatis.model;

import org.apache.ibatis.type.Alias;

@Alias("SysRoleResource")
public class SysRoleResource {

    private String role_id;
    private String resource_id;
    private String resource_type;

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

}