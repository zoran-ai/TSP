package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysDataDictItem;

@Repository
public class SysDataDictItemDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysDataDictItem";

    public int insertSysDataDictItem(SysDataDictItem obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysDataDictItem", obj);
    }

    public int updateSysDataDictItem(SysDataDictItem obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysDataDictItem", obj);
    }

    public int deleteSysDataDictItem(SysDataDictItem obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysDataDictItem", obj);
    }

    public SysDataDictItem selectSysDataDictItemByPk(SysDataDictItem obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysDataDictItemByPk", obj);
    }

}