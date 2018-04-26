package com.relesee.dao.impl;

import java.util.List;
import com.relesee.bean.SocketMessage;
import com.relesee.dao.MessageDao;

/**
 * 
 * @author jinfeng
 * @since 1.0.0
 * @time 2018.4.24
 */
public class MessageDaoImpl extends BaseDaoImpl implements MessageDao {
	/**
	 * @param  messageid, 具体所要操作的id，type=1为操作senderid其他则为操作accepterid
	 * 
	 * @return 返回List<SocketMessage>  
	 */
	@Override
	public List<SocketMessage> findMessageById(String messageid, int type) {
		String sql = "select senderid,accepterid,time,text,notes,MessageType from MessageRecords ";
		if(type==MessageDao.DO_BY_ACCEPTER){
			sql+= "where senderid="+messageid;
		}else{
			sql+= "where accepterid"+messageid;
		}
		return this.find(sql, SocketMessage.class);
	}

	
	/**
	 * @param  messageid, 具体所要操作的id，type=1为操作senderid其他则为操作accepterid
	 * 
	 * @return 返回List<SocketMessage>  
	 */
	@Override
	public boolean deleteById(String messageid, int type) {
		String sql;
		if(type==MessageDao.DO_BY_ACCEPTER){
			sql= "delete from messagerecords where senderid=?";
		}else{
			sql = "delete from messagerecords where accepterid=?";
		}
		Object[] obj = new Object[]{
				   messageid
				};
		return this.updateByParam(sql, obj);
	}

	
	/**
	 * @return 保存成功返回true
	 * @param message要保存的消息对象
	 */
	@Override
	public boolean addMessage(SocketMessage message) {
		
		String sql = "insert into MessageRecords(senderid,AccepterId,time,text,state,Notes,MessageType) "
				+ "values(?,?,?,?,?,?,?)";
		
		Object[] obj = new Object[]{
			message.getSenderid(),
			message.getAccepterid(),
			message.getTime(),
			message.getText(),
			message.getState(),
			message.getNotes(),
			message.getMessagetype()
			
		};
		return this.updateByParam(sql, obj);
	}
	
}
