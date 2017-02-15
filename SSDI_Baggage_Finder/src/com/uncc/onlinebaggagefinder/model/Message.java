package com.uncc.onlinebaggagefinder.model;

import java.util.Date;

public class Message {
String sender,receiver,messageDate,message;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
int requestWeight,postWeight,postID,msgID;
public int getMsgID() {
	return msgID;
}
public void setMsgID(int msgID) {
	this.msgID = msgID;
}
boolean approved;
public Message() {
	super();
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public String getMessageDate() {
	return messageDate;
}
public void setMessageDate(String messageDate) {
	this.messageDate = messageDate;
}
public int getRequestWeight() {
	return requestWeight;
}
public void setRequestWeight(int requestWeight) {
	this.requestWeight = requestWeight;
}
public int getPostWeight() {
	return postWeight;
}
public void setPostWeight(int postWeight) {
	this.postWeight = postWeight;
}
public int getPostID() {
	return postID;
}
public void setPostID(int postID) {
	this.postID = postID;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}
@Override
public String toString() {
	return "Message [sender=" + sender + ", receiver=" + receiver
			+ ", messageDate=" + messageDate + ", requestWeight=" + requestWeight + ", postWeight=" + postWeight
			+ ", postID=" + postID + ", approved=" + approved + "]";
}

}
