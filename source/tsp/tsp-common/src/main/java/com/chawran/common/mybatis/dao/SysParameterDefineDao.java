package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.SysParameterDefine;

@Repository
public class SysParameterDefineDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.SysParameterDefine";

    public int insertSysParameterDefine(SysParameterDefine obj) throws Exception {
        return insert(NAMESPACE + "." + "insertSysParameterDefine", obj);
    }

    public int updateSysParameterDefine(SysParameterDefine obj) throws Exception {
        return update(NAMESPACE + "." + "updateSysParameterDefine", obj);
    }

    public int deleteSysParameterDefine(SysParameterDefine obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteSysParameterDefine", obj);
    }

    public SysParameterDefine selectSysParameterDefineByPk(SysParameterDefine obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectSysParameterDefineByPk", obj);
    }

}