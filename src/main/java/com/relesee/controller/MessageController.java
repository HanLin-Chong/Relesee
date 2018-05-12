package com.relesee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relesee.bean.SocketMessage;
import com.relesee.bean.UserType;
import com.relesee.dao.MessageDao;
import com.relesee.services.MessageService;

import net.sf.json.JSONArray;


/**
 * 
 * @author jinfeng
 * 	获取未读消息，前端需要message的id，Sender或者Accepter的都可以；
 */ 
@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@RequestMapping("/get_message")
	public void getMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		List<SocketMessage> messageList;
		String targetId = req.getParameter("id");
		if(targetId.startsWith(UserType.getName(2))){
			List<SocketMessage>  list = new ArrayList<SocketMessage>();
			list = messageService.getMessageByAccepterId(targetId, MessageDao.MESSAGE_READ);
			messageList = messageService.getMessageByAccepterId(targetId, MessageDao.MEESAGE_NOT_READ);
			messageList.addAll(list);
		
		}else{
			List<SocketMessage>  list = new ArrayList<SocketMessage>();
			list = messageService.getMessageByAccepterId(targetId, MessageDao.MESSAGE_READ);
			messageList = messageService.getMessageSendererId(targetId, MessageDao.MEESAGE_NOT_READ);
			messageList.addAll(list);
		}
		resp.getWriter().write(JSONArray.fromObject(messageList).toString());
	}
	
	@RequestMapping("get_history_message")
	public void getHistoryMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		List<SocketMessage> messageList;
		String targetId = req.getParameter("id");
		if(targetId.startsWith("MSID")){
			messageList = messageService.getMessageByAccepterId(targetId, MessageDao.MEESAGE_NOT_READ);
		}else{
			messageList = messageService.getMessageSendererId(targetId, MessageDao.MEESAGE_NOT_READ);
		}
		resp.getWriter().write(JSONArray.fromObject(messageList).toString());
	}
	
	@RequestMapping("/read_meesage")
	public void readMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	   	int successedCount;
		 String messageid = req.getParameter("message_list");
		 String[] messageList = messageid.split(";");
	   	successedCount = this.messageService.updateByMessage(messageList, MessageDao.MESSAGE_READ);
		 resp.getWriter().write(successedCount+"条消息已执行成功");
	}
}
