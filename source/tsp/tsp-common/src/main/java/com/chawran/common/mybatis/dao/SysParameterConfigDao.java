package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysParameterConfig;

@Repository
public class SysParameterConfigDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysParameterConfig";

    public int insertSysParameterConfig(SysParameterConfig obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysParameterConfig", obj);
    }

    public int updateSysParameterConfig(SysParameterConfig obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysParameterConfig", obj);
    }

    public int deleteSysParameterConfig(SysParameterConfig obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysParameterConfig", obj);
    }

    public SysParameterConfig selectSysParameterConfigByPk(SysParameterConfig obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysParameterConfigByPk", obj);
    }

}