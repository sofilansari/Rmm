package com.ids.argus.dto;

import com.ids.argus.model.Notification;

public class NotificationDto {
	
	private Long id;
	private String subject;
	private String notification;
	private Short states;
	private boolean isDelete;
	
	public NotificationDto toDto(Notification notification) {
		
		NotificationDto dto=new NotificationDto();
		dto.setId(notification.getId());
		dto.setStates(notification.getStates());
		dto.setSubject(notification.getSubject());
		dto.setNotification(notification.getNotification());
		dto.setDelete(notification.isDelete());
		
		
		return dto;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public Short getStates() {
		return states;
	}
	public void setStates(Short states) {
		this.states = states;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
