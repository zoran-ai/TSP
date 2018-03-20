package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysRoleResource;

@Repository
public class SysRoleResourceDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysRoleResource";

    public int insertSysRoleResource(SysRoleResource obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysRoleResource", obj);
    }

    public int updateSysRoleResource(SysRoleResource obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysRoleResource", obj);
    }

    public int deleteSysRoleResource(SysRoleResource obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysRoleResource", obj);
    }

    public SysRoleResource selectSysRoleResourceByPk(SysRoleResource obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysRoleResourceByPk", obj);
    }

}