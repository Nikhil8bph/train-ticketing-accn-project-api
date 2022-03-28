package com.java.main.message;

import java.util.List;

public class ResponseMessageList {
	List<String> messageList;

	public ResponseMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	@Override
	public String toString() {
		return "ResponseMessageList [messageList=" + messageList + "]";
	}
	
	
}
