package com.chawran.common.mybatis.model;

import org.apache.ibatis.type.Alias;

@Alias("SysSearchDefine")
public class SysSearchDefine {

    private String search_code;
    private String search_name;
    private String description;

    public String getSearch_code() {
        return search_code;
    }

    public void setSearch_code(String search_code) {
        this.search_code = search_code;
    }

    public String getSearch_name() {
        return search_name;
    }

    public void setSearch_name(String search_name) {
        this.search_name = search_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}