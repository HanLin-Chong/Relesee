package com.relesee.dao;

import java.util.List;
import com.relesee.bean.SocketMessage;
/**
 * 
 * @author jinfeng
 * 消息的接口，主要根据发送者的id与接受者的id船
 */
public interface MessageDao {

	static final int DO_BY_SENDERID = 1;
	static final int DO_BY_ACCEPTER = 2;
	
	public List<SocketMessage> findMessageById(String messageid, int type);
	public boolean deleteById(String message, int type);
	public boolean addMessage(SocketMessage messaeg);
	
}
