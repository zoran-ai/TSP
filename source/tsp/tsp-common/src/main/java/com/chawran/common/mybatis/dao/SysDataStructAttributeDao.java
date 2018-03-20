package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataStructAttribute;

@Repository
public class SysDataStructAttributeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataStructAttribute";

    public int insertSysDataStructAttribute(SysDataStructAttribute obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataStructAttribute", obj);
    }

    public int updateSysDataStructAttribute(SysDataStructAttribute obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataStructAttribute", obj);
    }

    public int deleteSysDataStructAttribute(SysDataStructAttribute obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataStructAttribute", obj);
    }

    public SysDataStructAttribute selectSysDataStructAttributeByPk(SysDataStructAttribute obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataStructAttributeByPk", obj);
    }

}