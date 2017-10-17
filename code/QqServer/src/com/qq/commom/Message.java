package com.qq.commom;

import java.io.Serializable;

public class Message implements Serializable {
	private String messType;
	private String Sender;
	private String getter;
	private String con;
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	private String sendTime;
	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessType() {
		return messType;
	}

	public void setMessType(String messType) {
		this.messType = messType;
	}
	
	
}
