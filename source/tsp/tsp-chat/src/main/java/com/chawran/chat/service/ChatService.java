package com.chawran.chat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chawran.chat.dao.ChatDao;
import com.chawran.common.mybatis.dao.MsgCssChatDao;
import com.chawran.common.mybatis.dao.MsgTenantChatDao;

@Service
@SuppressWarnings("all")
public class ChatService {

	@Resource
	private ChatDao chatDao;
	
	@Resource
	private MsgTenantChatDao mtChatDao;
	
	@Resource
	private MsgCssChatDao mcChatDao;
	
	
}
