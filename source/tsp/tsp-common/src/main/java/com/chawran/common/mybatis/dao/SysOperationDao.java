package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysOperation;

@Repository
public class SysOperationDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysOperation";

    public int insertSysOperation(SysOperation obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysOperation", obj);
    }

    public int updateSysOperation(SysOperation obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysOperation", obj);
    }

    public int deleteSysOperation(SysOperation obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysOperation", obj);
    }

    public SysOperation selectSysOperationByPk(SysOperation obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysOperationByPk", obj);
    }

}