package com.relesee.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jinfeng
 *
 */
public class SocketMessage {
	

	private String senderid;
	private String accepterid;
	private String text;
	private String time;
	private String messagetype;
	private String notes;
	private String state;
	private String messageid;
	
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}
	
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getAccepterid() {
		return accepterid;
	}
	public void setAccepterid(String accepterid) {
		this.accepterid = accepterid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public static String generateId(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateToString = "MSID"+format.format(date).toString();
		return dateToString;
	}
	
}
