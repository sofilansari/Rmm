package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String taskName;
	private boolean state;
	private boolean isDelete;
	private boolean practices;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long id, String taskName, boolean state, boolean isDelete, boolean practices, Users users) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.state = state;
		this.isDelete = isDelete;
		this.practices = practices;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public boolean isPractices() {
		return practices;
	}

	public void setPractices(boolean practices) {
		this.practices = practices;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	

}
