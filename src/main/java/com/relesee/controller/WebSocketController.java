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

import com.relesee.bean.User;
import com.relesee.websocket.MyWebSocketHandler;

@Controller
@RequestMapping()
public class WebSocketController {
	private final org.apache.commons.logging.Log logger =LogFactory.getLog(WebSocketController.class);
	@Autowired private MyWebSocketHandler myWebSocketHandler;
	@RequestMapping("/test")
	public void sendMessage(HttpServletResponse resp, HttpServletRequest req){
		
		//获取消息的发送者与接收者
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String  messageFrom = user.getUserid();
		String meesageTo = req.getParameter("messageto");
		
		TextMessage message = new TextMessage("This is a test");
		try {
			logger.info("webSocket send message"+message.toString());
			myWebSocketHandler.sendMessageToTarget(message,"MSID_0000005");
			resp.getWriter().write(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
