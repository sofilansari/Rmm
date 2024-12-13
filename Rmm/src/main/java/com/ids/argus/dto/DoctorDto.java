package com.ids.argus.dto;

import com.ids.argus.model.Doctor;

public class DoctorDto {
	
	private String type;
	private String firstName;
	private String lastName;
	private String groupName;
	private boolean state;
	private boolean isDelete;
	private String speciality;
	private String emailId;
	private String alternativeEmailId;
	
	public DoctorDto toDo(Doctor doctor) {
		
		DoctorDto dto=new DoctorDto();
		dto.setType(doctor.getType());
		dto.setFirstName(doctor.getFirstName());
		dto.setLastName(doctor.getLastName());
		dto.setGroupName(doctor.getGroupName());
		dto.setState(doctor.isState());
		dto.setisDelete(doctor.isDelete());
		dto.setSpeciality(doctor.getSpeciality());
		dto.setEmailId(doctor.getEmailId());
		dto.setAlternativeEmailId(doctor.getAlternativeEmailId());
		
		return dto;	
	

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

	public void setisDelete(boolean isDelete) {
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