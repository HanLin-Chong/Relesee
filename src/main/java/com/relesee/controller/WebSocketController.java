package com.relesee.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import com.relesee.bean.SocketMessage;
import com.relesee.bean.User;
import com.relesee.services.WebSocketService;
import com.relesee.util.DateUtil;
import com.relesee.websocket.MyWebSocketHandler;


/**
 * 
 * @author jinfeng
 * 	websocket的controller类， 
 * @param  text 发送消息的内容, accepterid消息的接受着
 */
@Controller
@RequestMapping("message")
public class WebSocketController {
	private final org.apache.commons.logging.Log logger =LogFactory.getLog(WebSocketController.class);
	
	//消息类型  设置默认的消息类型为普通
	
	private final String  MESSAGE_STATE = "普通";
	
	@Autowired private WebSocketService webSocketService;
	
	@RequestMapping("/send")
	public void SendMessage(HttpServletResponse resp, HttpServletRequest req){

		
		//获取消息的发送者与接收者
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String  messageFrom = user.getUserid();
		String accepterid= req.getParameter("accepterid");
		String text = req.getParameter("text");
		
		// 组成消息对象
		SocketMessage message = new SocketMessage();
		message.setAccepterid(accepterid);
		message.setSenderid(user.getUserid());
		message.setText(text);
		message.setTime(DateUtil.getTime());
		message.setState(MESSAGE_STATE);
		message.setText(text);
		//发送消息
		webSocketService.sendMessage(message);

	}
	
	public void sendMessage(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String  messageFrom = user.getUserid();
		String messageTo = req.getParameter("messageto");

		SocketMessage message = new SocketMessage();
		message.setAccepterid(messageFrom );
		message.setSenderid(user.getUserid());
		message.setTime(DateUtil.getTime());
		message.setState(MESSAGE_STATE);
		webSocketService.sendMessage(message);
	}
}
