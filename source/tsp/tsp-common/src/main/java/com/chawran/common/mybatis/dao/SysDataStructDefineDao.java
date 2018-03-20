package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataStructDefine;

@Repository
public class SysDataStructDefineDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataStructDefine";

    public int insertSysDataStructDefine(SysDataStructDefine obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataStructDefine", obj);
    }

    public int updateSysDataStructDefine(SysDataStructDefine obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataStructDefine", obj);
    }

    public int deleteSysDataStructDefine(SysDataStructDefine obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataStructDefine", obj);
    }

    public SysDataStructDefine selectSysDataStructDefineByPk(SysDataStructDefine obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataStructDefineByPk", obj);
    }

}