package com.relesee.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.relesee.bean.SocketMessage;
import com.relesee.dao.MessageDao;

/**
 * 
 * @author jinfeng
 * @since 1.0.0
 * @time 2018.4.24
 */

@Repository("messageDaoImpl")
public class MessageDaoImpl extends BaseDaoImpl implements MessageDao {
	/**
	 * @param  messageid, 具体所要操作的id，type=1为操作senderid其他则为操作accepterid
	 *  state  消息的状态，MessageDao.MESSAGE_NOT_READ 以及 MessageDao.MESSAGE_READ;
	 * 
	 * @return 返回List<SocketMessage>  
	 */
	@Override
	public List<SocketMessage> findMessageById(String messageid, int type, int state) {
		String sql = "select senderid,accepterid,time,text,notes,MessageType from MessageRecords ";
		switch(state){
		//消息已读
		case MessageDao.MEESAGE_NOT_READ:
			if(type==MessageDao.DO_BY_ACCEPTER){
				sql+= "where senderid="+"'"+messageid+"' and state="+"'"+MessageDao.MEESAGE_NOT_READ+"";
			}else{
				sql+= "where accepterid"+"'"+messageid+"' and state="+"'"+MessageDao.MEESAGE_NOT_READ+"";
			}
			break;
		//未读消息
		case MessageDao.MESSAGE_READ:if(type==MessageDao.DO_BY_ACCEPTER){
			sql+= "where senderid="+"'"+messageid+"' and state="+"'"+MessageDao.MESSAGE_READ+"'";
		}else{
			sql+= "where accepterid"+"'"+messageid+"' and state="+"'"+MessageDao.MESSAGE_READ+"'";
		}
			break;
		default:
			break;
			
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
		// 将以下的相关参数书保存到数据库中
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

	/**
	 * @param id 操作message对象的id，包括senderid与accepterid
	 * @para type 操作对应的类别，分别未MessageDao.DO_ACCEPTERI与MessageDao.DO_BY_SENDERID
	 * @return true 操作成功
	 *  
	 */
	@Override
	public boolean updateMessageById(String id, int type, int newState) {
		//sql
		Object[] obj = new Object[]{
				id,
				newState
		};
		if(type == MessageDao.DO_BY_ACCEPTER){
			String sql = "update MessageRecords set state = ? where accepterid=?";
			return this.updateByParam(sql, obj);
		}else if(type == MessageDao.DO_BY_SENDERID){
			String sql = "update MessageRecords set state = ? where SenderId=?";
			return this.updateByParam(sql, obj);
		}else{
			return false;
		}
		
	}

	
}
