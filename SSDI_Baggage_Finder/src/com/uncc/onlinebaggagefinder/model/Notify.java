package com.uncc.onlinebaggagefinder.model;

public class Notify {
	String notify_msg;
	String notified_from;
	String notified_to;
	String contact_details;
	String notify_date ;
	boolean notification_status;
	
	public boolean isNotification_status() {
		return notification_status;
	}
	public void setNotification_status(boolean notification_status) {
		this.notification_status = notification_status;
	}
	public String getNotify_msg() {
		return notify_msg;
	}
	public void setNotify_msg(String notify_msg) {
		this.notify_msg = notify_msg;
	}
	public String getNotified_from() {
		return notified_from;
	}
	public void setNotified_from(String notified_from) {
		this.notified_from = notified_from;
	}
	public String getNotified_to() {
		return notified_to;
	}
	public void setNotified_to(String notified_to) {
		this.notified_to = notified_to;
	}
	public String getContact_details() {
		return contact_details;
	}
	public void setContact_details(String contact_details) {
		this.contact_details = contact_details;
	}
	public String getNotify_date() {
		return notify_date;
	}
	public void setNotify_date(String notify_date) {
		this.notify_date = notify_date;
	}
	@Override
	public String toString() {
		return "Notify [notify_msg=" + notify_msg + ", notified_from=" + notified_from + ", notified_to=" + notified_to
				+ ", contact_details=" + contact_details + ", notify_date=" + notify_date + "]";
	}
	public Notify(String notify_msg, String notified_from, String notified_to, String contact_details,
			String notify_date) {
		super();
		this.notify_msg = notify_msg;
		this.notified_from = notified_from;
		this.notified_to = notified_to;
		this.contact_details = contact_details;
		this.notify_date = notify_date;
	}
	public Notify() {
		super();
	}
	
}
