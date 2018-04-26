package com.relesee.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import com.relesee.bean.SocketMessage;
import com.relesee.dao.MessageDao;
import com.relesee.dao.impl.MessageDaoImpl;
import com.relesee.websocket.MyWebSocketHandler;

/**
 * 
 * @author jinfeng
 * wesocket服务，提供发送消息，查找消息，删除消息
 */
@Service
public class WebSocketService {
	
	@Autowired private MyWebSocketHandler myWebSocketHandler;
	@Autowired private MessageDaoImpl messageDaoImpl;
	
	/**
	 * 
	 * @param message 要发送的消息对象
	 * 根据发送对象的Accepterid从handler中判断用户是否在线
	 *  若用户在线,若用在线则发送消息
	 */
	public void sendMessage(SocketMessage message){
		
		TextMessage testMessage = new TextMessage(message.getText());
		
		// true表示接受消息的用户处在在线的状态
		if(myWebSocketHandler.sendMessageToTarget(testMessage,message.getAccepterid())){
			message.setState(""+MessageDao.MESSAGE_READ);
			messageDaoImpl.addMessage(message);
		}else{
			message.setState(""+MessageDao.MEESAGE_NOT_READ);
			messageDaoImpl.addMessage(message);
		}
	}
}
