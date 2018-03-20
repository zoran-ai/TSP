package com.chawran.common.mybatis.model;

import org.apache.ibatis.type.Alias;

@Alias("SysSearchColumn")
public class SysSearchColumn {

    private String column_code;
    private String search_code;
    private String column_name;
    private String column_sql;
    private String operation_symbol;
    private String element_type;
    private String ddt_code;
    private String lov_code;
    private String ds_code;
    private String display_order;
    private String description;

    public String getColumn_code() {
        return column_code;
    }

    public void setColumn_code(String column_code) {
        this.column_code = column_code;
    }

    public String getSearch_code() {
        return search_code;
    }

    public void setSearch_code(String search_code) {
        this.search_code = search_code;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getColumn_sql() {
        return column_sql;
    }

    public void setColumn_sql(String column_sql) {
        this.column_sql = column_sql;
    }

    public String getOperation_symbol() {
        return operation_symbol;
    }

    public void setOperation_symbol(String operation_symbol) {
        this.operation_symbol = operation_symbol;
    }

    public String getElement_type() {
        return element_type;
    }

    public void setElement_type(String element_type) {
        this.element_type = element_type;
    }

    public String getDdt_code() {
        return ddt_code;
    }

    public void setDdt_code(String ddt_code) {
        this.ddt_code = ddt_code;
    }

    public String getLov_code() {
        return lov_code;
    }

    public void setLov_code(String lov_code) {
        this.lov_code = lov_code;
    }

    public String getDs_code() {
        return ds_code;
    }

    public void setDs_code(String ds_code) {
        this.ds_code = ds_code;
    }

    public String getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(String display_order) {
        this.display_order = display_order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}