package com.ids.argus.dto;

import com.ids.argus.model.Category;

public class CategoryDto {
	
	private Long id;
	private String name;
	private String stats;
	private String type;
	private boolean isDeteled;
	
	
	public CategoryDto toDo(Category category) {
		
		CategoryDto dto=new CategoryDto();
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setType(category.getType());
		dto.setDeteled(category.isDeleted());
		return dto;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStats() {
		return stats;
	}


	public void setStats(String stats) {
		this.stats = stats;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public boolean isDeteled() {
		return isDeteled;
	}


	public void setDeteled(boolean isDeteled) {
		this.isDeteled = isDeteled;
	}


	
}
