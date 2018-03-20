package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysSearchColumn;

@Repository
public class SysSearchColumnDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysSearchColumn";

    public int insertSysSearchColumn(SysSearchColumn obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysSearchColumn", obj);
    }

    public int updateSysSearchColumn(SysSearchColumn obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysSearchColumn", obj);
    }

    public int deleteSysSearchColumn(SysSearchColumn obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysSearchColumn", obj);
    }

    public SysSearchColumn selectSysSearchColumnByPk(SysSearchColumn obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysSearchColumnByPk", obj);
    }

}