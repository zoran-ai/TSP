package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysFunction;

@Repository
public class SysFunctionDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysFunction";

    public int insertSysFunction(SysFunction obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysFunction", obj);
    }

    public int updateSysFunction(SysFunction obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysFunction", obj);
    }

    public int deleteSysFunction(SysFunction obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysFunction", obj);
    }

    public SysFunction selectSysFunctionByPk(SysFunction obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysFunctionByPk", obj);
    }

}