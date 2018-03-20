package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataStructNodeAttribute;

@Repository
public class SysDataStructNodeAttributeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataStructNodeAttribute";

    public int insertSysDataStructNodeAttribute(SysDataStructNodeAttribute obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataStructNodeAttribute", obj);
    }

    public int updateSysDataStructNodeAttribute(SysDataStructNodeAttribute obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataStructNodeAttribute", obj);
    }

    public int deleteSysDataStructNodeAttribute(SysDataStructNodeAttribute obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataStructNodeAttribute", obj);
    }

    public SysDataStructNodeAttribute selectSysDataStructNodeAttributeByPk(SysDataStructNodeAttribute obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataStructNodeAttributeByPk", obj);
    }

}