package com.relesee.dao;

import java.util.List;
import com.relesee.bean.SocketMessage;
/**
 * 
 * @author jinfeng
 * 消息的接口，主要根据发送者的id与接受者的id
 */
public interface MessageDao {
	// 表示消息处于未读的状态
	static final int MEESAGE_NOT_READ = 0;
	//消息已被读取
	static final int MESSAGE_READ = 1;
   // 根据发送消息的用户操作
	static final int DO_BY_SENDERID = 1;
	// 根据接收消息的用户操作
	static final int DO_BY_ACCEPTER = 2;
	
	/**
	 * 
	 * @param messageid  查找id
	 * @param type 查找的消息类型
	 * @return 
	 */
	public List<SocketMessage> findMessageById(String messageid, int type, int state);
	public boolean deleteById(String message, int type);
	public boolean addMessage(SocketMessage messaeg);;
	
	public boolean updateMessageById(String id, int type, int newState);
	
}
