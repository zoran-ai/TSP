package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysLovDefine;

@Repository
public class SysLovDefineDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysLovDefine";

    public int insertSysLovDefine(SysLovDefine obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysLovDefine", obj);
    }

    public int updateSysLovDefine(SysLovDefine obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysLovDefine", obj);
    }

    public int deleteSysLovDefine(SysLovDefine obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysLovDefine", obj);
    }

    public SysLovDefine selectSysLovDefineByPk(SysLovDefine obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysLovDefineByPk", obj);
    }

}