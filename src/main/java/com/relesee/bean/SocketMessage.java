package com.relesee.bean;

public class SocketMessage {
	private String senderid;
	private String accepterid;
	private String text;
	private String time;
	private String messagetype;
	private String notes;
	private String state;
	
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
}
