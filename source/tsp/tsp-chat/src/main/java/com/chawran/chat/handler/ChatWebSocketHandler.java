package com.chawran.chat.handler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private final static Logger logger = LoggerFactory.getLogger(ChatWebSocketHandler.class);
			
	// 会话用户
	private static final Map<String, WebSocketSession> userSessionMap = new HashMap<String, WebSocketSession>();
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		TextMessage returnMessage = new TextMessage(message.getPayload());
		session.sendMessage(returnMessage);
		logger.info("handleTextMessage: " + message.getPayload());
	}
	
	@Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String tenantId = (String)session.getAttributes().get("tenantId");
		if (tenantId != null && !"".equals(tenantId)) {
			userSessionMap.put(tenantId, session);
			logger.info("afterConnectionEstablished:[" + tenantId + "]open connection to the websocket chat sucess...");
		} else {
			if(session.isOpen()){
	            session.close();
	        }
			logger.error("afterConnectionEstablished: open connection to the websocket chat failure without tenentId...");
		}
    }
	
	@Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		String userId = (String)session.getAttributes().get("TenentId");
		if (userId != null && !"".equals(userId)) {
			userSessionMap.remove(userId);
			logger.info("afterConnectionClosed:" + userId + " close connection to websocket chat...");
		}
    }
	
	@Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		String userId = (String)session.getAttributes().get("TenentId");
		if (userId != null && !"".equals(userId)) {
			userSessionMap.remove(userId);
			logger.info("handleTransportError:" + userId + " close connection to websocket chat...");
		}
		if(session.isOpen()){
            session.close();
        }
    }
	
	public void sendMessageToUser(String userId, String message) throws Exception {
		WebSocketSession session = userSessionMap.get(userId);
		if (session.isOpen()) {
			TextMessage returnMessage = new TextMessage(message);
			session.sendMessage(returnMessage);
		}
	}
	
	public void sendMessageToUsers(String message) throws Exception {
		if (userSessionMap != null && userSessionMap.size() > 0) {
			for (Map.Entry<String, WebSocketSession> entry : userSessionMap.entrySet()) {
				WebSocketSession session = entry.getValue();
				if (session.isOpen()) {
					TextMessage returnMessage = new TextMessage(message);
					session.sendMessage(returnMessage);
				}
			}
		}
	}
	
}
