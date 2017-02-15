package com.uncc.onlinebaggagefinder.model;

public class Post {
	int id;
String flightNo,airlines,name,userId,weight,source,destination,doj,datePosted,userName;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public String getDatePosted() {
	return datePosted;
}
public void setDatePosted(String datePosted) {
	this.datePosted = datePosted;
}
String statusMsg;

public Post() {
	super();
}
public Post(String flightNo, String airlines, String name, String userId,
		String weight, String source, String destination, String statusMsg) {
	super();
	this.flightNo = flightNo;
	this.airlines = airlines;
	this.name = name;
	this.userId = userId;
	this.weight = weight;
	this.source = source;
	this.destination = destination;
	this.statusMsg = statusMsg;
}
public String getFlightNo() {
	return flightNo;
}
public void setFlightNo(String flightNo) {
	this.flightNo = flightNo;
}
public String getAirlines() {
	return airlines;
}
public void setAirlines(String airlines) {
	this.airlines = airlines;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getStatusMsg() {
	return statusMsg;
}
public void setStatusMsg(String statusMsg) {
	this.statusMsg = statusMsg;
}
@Override
public String toString() {
	return "Post [flightNo=" + flightNo + ", airlines=" + airlines + ", name="
			+ name + ", userId=" + userId + ", weight=" + weight + ", source="
			+ source + ", destination=" + destination + ", statusMsg="
			+ statusMsg + "]";
}

}
