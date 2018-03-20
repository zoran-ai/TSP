package com.chawran.common.mybatis.model;

import org.apache.ibatis.type.Alias;

@Alias("SysUserRole")
public class SysUserRole {

    private String user_id;
    private String role_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

}