package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataStructNode;

@Repository
public class SysDataStructNodeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataStructNode";

    public int insertSysDataStructNode(SysDataStructNode obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataStructNode", obj);
    }

    public int updateSysDataStructNode(SysDataStructNode obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataStructNode", obj);
    }

    public int deleteSysDataStructNode(SysDataStructNode obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataStructNode", obj);
    }

    public SysDataStructNode selectSysDataStructNodeByPk(SysDataStructNode obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataStructNodeByPk", obj);
    }

}