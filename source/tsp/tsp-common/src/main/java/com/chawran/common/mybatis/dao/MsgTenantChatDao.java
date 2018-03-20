package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.MsgTenantChat;

@Repository
public class MsgTenantChatDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.MsgTenantChat";

    public int insertMsgTenantChat(MsgTenantChat obj) throws Exception {
        return insert(NAMESPACE + "." + "insertMsgTenantChat", obj);
    }

    public int updateMsgTenantChat(MsgTenantChat obj) throws Exception {
        return update(NAMESPACE + "." + "updateMsgTenantChat", obj);
    }

    public int deleteMsgTenantChat(MsgTenantChat obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteMsgTenantChat", obj);
    }

    public MsgTenantChat selectMsgTenantChatByPk(MsgTenantChat obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectMsgTenantChatByPk", obj);
    }

}