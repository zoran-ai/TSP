package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysUserRole;

@Repository
public class SysUserRoleDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysUserRole";

    public int insertSysUserRole(SysUserRole obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysUserRole", obj);
    }

    public int updateSysUserRole(SysUserRole obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysUserRole", obj);
    }

    public int deleteSysUserRole(SysUserRole obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysUserRole", obj);
    }

    public SysUserRole selectSysUserRoleByPk(SysUserRole obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysUserRoleByPk", obj);
    }

}