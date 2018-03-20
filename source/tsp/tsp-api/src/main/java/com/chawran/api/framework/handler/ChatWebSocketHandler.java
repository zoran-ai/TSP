package com.chawran.api.framework.handler;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private final static Logger logger = LoggerFactory.getLogger(ChatWebSocketHandler.class);
			
	private static final ArrayList<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		logger.info("handleTextMessage: " + message.getPayload());
		super.handleTextMessage(session, message);
		
		String fromUser = message.getPayload().split("@@")[0];
		String msg = message.getPayload().split("@@")[1];
		
		TextMessage returnMessage = new TextMessage(fromUser.equals("A") ? "B:" : "A:" + msg);
		session.sendMessage(returnMessage);
	}
	
	@Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
        logger.info("afterConnectionEstablished: connect to the websocket chat success...");
    }
	
	@Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		sessions.remove(session);
        logger.info("afterConnectionClosed: websocket chat connection closed......");
    }
	
	@Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        sessions.remove(session);
        logger.info("handleTransportError: websocket chat connection closed......");
    }
	
}
