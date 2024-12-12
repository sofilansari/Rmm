package com.ids.argus.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


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
	private boolean delete;
	private String speciality;
	private String emailId;
	private String alternativeEmailId;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Doctor(Long id, String type, String firstName, String lastName, String groupName, Boolean state,
			boolean delete, String speciality, String emailId, String alternativeEmailId) {
	
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupName = groupName;
		this.state = state;
		this.delete = delete;
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



	public Boolean getState() {
		return state;
	}



	public void setState(Boolean state) {
		this.state = state;
	}



	public boolean isDelete() {
		return delete;
	}



	public void setDelete(boolean delete) {
		this.delete = delete;
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
