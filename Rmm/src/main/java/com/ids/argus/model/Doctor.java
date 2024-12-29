package com.ids.argus.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private boolean deleted;
	private String speciality;
	private String emailId;
	private String alternativeEmailId;
	
	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Address> addresses;
	 
	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
	 private List<Contact>contacts;
	 
	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
	 private List<Category>categories;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long id, String type, String firstName, String lastName, String groupName, boolean state,
			boolean deleted, String speciality, String emailId, String alternativeEmailId, List<Address> addresses,
			List<Contact> contacts, List<Category> categories) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupName = groupName;
		this.state = state;
		this.deleted = deleted;
		this.speciality = speciality;
		this.emailId = emailId;
		this.alternativeEmailId = alternativeEmailId;
		this.addresses = addresses;
		this.contacts = contacts;
		this.categories = categories;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}	
	
}
