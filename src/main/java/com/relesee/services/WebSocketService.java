package com.relesee.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.relesee.bean.SocketMessage;
import com.relesee.websocket.MyWebSocketHandler;

@Service
public class WebSocketService {
	@Autowired private MyWebSocketHandler myWebSocketHandler;
	
	public void sendMessage(SocketMessage message){
		
	}
}
