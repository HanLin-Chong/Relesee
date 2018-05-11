package com.relesee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesee.bean.SocketMessage;
import com.relesee.dao.MessageDao;
import com.relesee.dao.impl.MessageDaoImpl;

/**
 * 
 * @author jinfeng
 * Message的具体服务层，主要为Contrller层提供Messagede 业务流程
 */
@Service
public class MessageService {
    @Autowired
    private MessageDaoImpl messageDaoImpl;
   
    /**
     * 根据消息接受者查看消息
     * @param accepterid  消息接收者的员工编号
     * @param state 消息的状态（已读、未读）
     * @return 返回查找结果的List
     */
    public List<SocketMessage> getMessageByAccepterId(String accepterid, int state){
    	return this.messageDaoImpl.findMessageById(accepterid, MessageDao.DO_BY_ACCEPTER, state);
    }
    
    /**
     * 根据消息发送者查看消息
     * @param accepterid  消息接收者的员工编号
     * @param state 消息的状态（已读、未读）
     * @return 返回查找结果的List
     */
    public List<SocketMessage> getMessageSendererId(String senderid, int state){
    	return this.messageDaoImpl.findMessageById(senderid, MessageDao.DO_BY_SENDERID, state);
    }
    
    /**
     * 
     * @param Accepterid
     * @param newState
     * @return
     */
    public int updateByMessage(String[]  idList , int state){
    	//成功改变消息状态个数
    	int count = 0;
    	for(String id : idList){
    		if(this.messageDaoImpl.updateMessageById(id, state));
    		count++;
    	}
    	return count;
    }
    
}
