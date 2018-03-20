package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysRole;

@Repository
public class SysRoleDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysRole";

    public int insertSysRole(SysRole obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysRole", obj);
    }

    public int updateSysRole(SysRole obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysRole", obj);
    }

    public int deleteSysRole(SysRole obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysRole", obj);
    }

    public SysRole selectSysRoleByPk(SysRole obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysRoleByPk", obj);
    }

}