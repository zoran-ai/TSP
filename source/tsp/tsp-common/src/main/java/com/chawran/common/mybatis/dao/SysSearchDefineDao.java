package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysSearchDefine;

@Repository
public class SysSearchDefineDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysSearchDefine";

    public int insertSysSearchDefine(SysSearchDefine obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysSearchDefine", obj);
    }

    public int updateSysSearchDefine(SysSearchDefine obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysSearchDefine", obj);
    }

    public int deleteSysSearchDefine(SysSearchDefine obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysSearchDefine", obj);
    }

    public SysSearchDefine selectSysSearchDefineByPk(SysSearchDefine obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysSearchDefineByPk", obj);
    }

}