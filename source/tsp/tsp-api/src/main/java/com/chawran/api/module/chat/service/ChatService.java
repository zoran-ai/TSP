package com.chawran.api.module.chat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chawran.api.module.chat.dao.ChatDao;

@Service
@SuppressWarnings("all")
public class ChatService {

	@Resource
	private ChatDao chatDao;
	
	
	
}
