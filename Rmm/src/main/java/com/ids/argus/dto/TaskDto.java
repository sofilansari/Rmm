package com.ids.argus.dto;

import com.ids.argus.model.Task;

public class TaskDto {
	
	private Long id;
	private String taskName;
	private boolean state;
	private boolean isDelete;
	private boolean practices;
	
	public TaskDto toDto(Task task) {
		
		TaskDto dto=new TaskDto();
		dto.setId(task.getId());
		dto.setTaskName(task.getTaskName());
		dto.setDelete(task.isDelete());
		dto.setState(task.isState());
		dto.setDelete(task.isDelete());
		
		return dto;
		
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
	
	
	

}
