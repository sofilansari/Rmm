package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category extends BaseAuditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String stats;
	private String type;
	private boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name, String stats, String type, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.stats = stats;
		this.type = type;
		this.isDeleted = isDeleted;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	

}
