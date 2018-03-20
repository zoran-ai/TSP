package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysLovColumn;

@Repository
public class SysLovColumnDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysLovColumn";

    public int insertSysLovColumn(SysLovColumn obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysLovColumn", obj);
    }

    public int updateSysLovColumn(SysLovColumn obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysLovColumn", obj);
    }

    public int deleteSysLovColumn(SysLovColumn obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysLovColumn", obj);
    }

    public SysLovColumn selectSysLovColumnByPk(SysLovColumn obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysLovColumnByPk", obj);
    }

}