package com.ids.argus.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Doctor extends BaseAuditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String firstName;
	private String lastName;
	private String groupName;
	private boolean state;
	private boolean isDelete;
	private String speciality;
	private String emailId;
	private String alternativeEmailId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private List<Category>categories;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Address>addresses;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Contact>contacts;
	
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long id, String type, String firstName, String lastName, String groupName, boolean state,
			boolean isDelete, String speciality, String emailId, String alternativeEmailId) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupName = groupName;
		this.state = state;
		this.isDelete = isDelete;
		this.speciality = speciality;
		this.emailId = emailId;
		this.alternativeEmailId = alternativeEmailId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAlternativeEmailId() {
		return alternativeEmailId;
	}

	public void setAlternativeEmailId(String alternativeEmailId) {
		this.alternativeEmailId = alternativeEmailId;
	}
	

	
}
