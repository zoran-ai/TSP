package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysUser;

@Repository
public class SysUserDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysUser";

    public int insertSysUser(SysUser obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysUser", obj);
    }

    public int updateSysUser(SysUser obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysUser", obj);
    }

    public int deleteSysUser(SysUser obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysUser", obj);
    }

    public SysUser selectSysUserByPk(SysUser obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysUserByPk", obj);
    }

}