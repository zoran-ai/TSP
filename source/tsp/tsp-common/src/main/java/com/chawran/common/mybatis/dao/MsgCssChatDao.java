package com.chawran.common.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

import com.chawran.common.mybatis.model.MsgCssChat;

@Repository
public class MsgCssChatDao extends BaseDao {

    public static final String NAMESPACE = "com.chawran.common.mybatis.mapper.MsgCssChat";

    public int insertMsgCssChat(MsgCssChat obj) throws Exception {
        return insert(NAMESPACE + "." + "insertMsgCssChat", obj);
    }

    public int updateMsgCssChat(MsgCssChat obj) throws Exception {
        return update(NAMESPACE + "." + "updateMsgCssChat", obj);
    }

    public int deleteMsgCssChat(MsgCssChat obj) throws Exception {
        return delete(NAMESPACE  + "." + "deleteMsgCssChat", obj);
    }

    public MsgCssChat selectMsgCssChatByPk(MsgCssChat obj) throws Exception {
        return selectOne(NAMESPACE + "." + "selectMsgCssChatByPk", obj);
    }

}