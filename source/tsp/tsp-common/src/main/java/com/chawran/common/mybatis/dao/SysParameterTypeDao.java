package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysParameterType;

@Repository
public class SysParameterTypeDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysParameterType";

    public int insertSysParameterType(SysParameterType obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysParameterType", obj);
    }

    public int updateSysParameterType(SysParameterType obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysParameterType", obj);
    }

    public int deleteSysParameterType(SysParameterType obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysParameterType", obj);
    }

    public SysParameterType selectSysParameterTypeByPk(SysParameterType obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysParameterTypeByPk", obj);
    }

}