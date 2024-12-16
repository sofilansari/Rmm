package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	private String notification;
	private Short states;
	private boolean isDelete;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Long id, String subject, String notification, Short states, boolean isDelete) {
		super();
		this.id = id;
		this.subject = subject;
		this.notification = notification;
		this.states = states;
		this.isDelete = isDelete;
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
