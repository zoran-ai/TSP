package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataDictItemAttribute;

@Repository
public class SysDataDictItemAttributeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataDictItemAttribute";

    public int insertSysDataDictItemAttribute(SysDataDictItemAttribute obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataDictItemAttribute", obj);
    }

    public int updateSysDataDictItemAttribute(SysDataDictItemAttribute obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataDictItemAttribute", obj);
    }

    public int deleteSysDataDictItemAttribute(SysDataDictItemAttribute obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataDictItemAttribute", obj);
    }

    public SysDataDictItemAttribute selectSysDataDictItemAttributeByPk(SysDataDictItemAttribute obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataDictItemAttributeByPk", obj);
    }

}