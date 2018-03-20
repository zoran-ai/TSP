package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataDictTypeAttribute;

@Repository
public class SysDataDictTypeAttributeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataDictTypeAttribute";

    public int insertSysDataDictTypeAttribute(SysDataDictTypeAttribute obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataDictTypeAttribute", obj);
    }

    public int updateSysDataDictTypeAttribute(SysDataDictTypeAttribute obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataDictTypeAttribute", obj);
    }

    public int deleteSysDataDictTypeAttribute(SysDataDictTypeAttribute obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataDictTypeAttribute", obj);
    }

    public SysDataDictTypeAttribute selectSysDataDictTypeAttributeByPk(SysDataDictTypeAttribute obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataDictTypeAttributeByPk", obj);
    }

}