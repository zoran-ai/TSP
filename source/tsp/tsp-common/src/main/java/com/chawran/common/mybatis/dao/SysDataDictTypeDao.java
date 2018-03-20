package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataDictType;

@Repository
public class SysDataDictTypeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataDictType";

    public int insertSysDataDictType(SysDataDictType obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataDictType", obj);
    }

    public int updateSysDataDictType(SysDataDictType obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataDictType", obj);
    }

    public int deleteSysDataDictType(SysDataDictType obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataDictType", obj);
    }

    public SysDataDictType selectSysDataDictTypeByPk(SysDataDictType obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataDictTypeByPk", obj);
    }

}