package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysLog;

@Repository
public class SysLogDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysLog";

    public int insertSysLog(SysLog obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysLog", obj);
    }

    public int updateSysLog(SysLog obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysLog", obj);
    }

    public int deleteSysLog(SysLog obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysLog", obj);
    }

    public SysLog selectSysLogByPk(SysLog obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysLogByPk", obj);
    }

}