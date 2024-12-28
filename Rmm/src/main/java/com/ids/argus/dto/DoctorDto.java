package com.ids.argus.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.ids.argus.model.Doctor;

import jakarta.persistence.Column;

public class DoctorDto {
	
<<<<<<< HEAD
	    private Long id;
	    private String type;
	    private String firstName;
	    private String lastName;
	    private String groupName;
	    private boolean state;
	    private boolean isDeleted;  
	    private String speciality;
	    private String emailId;
	    private String alternativeEmailId;
=======
	private Long id;
	private String type;
	private String firstName;
	private String lastName;
	private String groupName;
	private boolean state;
	@Column(name = "is_deleted")
	private boolean deleted;
	private String speciality;
	private String emailId;
	private String alternativeEmailId;
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
	    private List<CategoryDto> categories;
	    private List<AddressDto> addresses;
	    private List<ContactDto> contacts;
		private boolean delete;

	    
	    public DoctorDto toDto(Doctor doctor) {  
	        DoctorDto dto = new DoctorDto();
	        dto.setId(doctor.getId());
	        dto.setType(doctor.getType());
	        dto.setFirstName(doctor.getFirstName());
	        dto.setLastName(doctor.getLastName());
	        dto.setGroupName(doctor.getGroupName());
	        dto.setState(doctor.isState());
<<<<<<< HEAD
	        dto.setDeleted(doctor.isDelete());  
=======
	        dto.setDelete(doctor.isDeleted());  // Fix the mapping to isDeleted() instead of isDelete()
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
	        dto.setSpeciality(doctor.getSpeciality());
	        dto.setEmailId(doctor.getEmailId());
	        dto.setAlternativeEmailId(doctor.getAlternativeEmailId());

	        
	        if (doctor.getCategories() != null) {
	            dto.setCategories(doctor.getCategories().stream()
	                .map(category -> new CategoryDto().toDo(category))  
	                .collect(Collectors.toList()));
	        }

	        if (doctor.getAddresses() != null) {
	            dto.setAddresses(doctor.getAddresses().stream()
	                .map(address -> new AddressDto().toDto(address))  
	                .collect(Collectors.toList()));
	        }

	        if (doctor.getContacts() != null) {
	            dto.setContacts(doctor.getContacts().stream()
	                .map(contact -> new ContactDto().toDo(contact))  
	                .collect(Collectors.toList()));
	        }

	        return dto;
	    }

<<<<<<< HEAD
	   
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
	        return isDeleted;
	    }
	    public void setDeleted(boolean isDeleted) {
	        this.isDeleted = isDeleted;
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
	    public List<CategoryDto> getCategories() {
	        return categories;
	    }
	    public void setCategories(List<CategoryDto> categories) {
	        this.categories = categories;
	    }
	    public List<AddressDto> getAddresses() {
	        return addresses;
	    }
	    public void setAddresses(List<AddressDto> addresses) {
	        this.addresses = addresses;
	    }
	    public List<ContactDto> getContacts() {
	        return contacts;
	    }
	    public void setContacts(List<ContactDto> contacts) {
	        this.contacts = contacts;
	    }
=======
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

		public List<CategoryDto> getCategories() {
			return categories;
		}

		public void setCategories(List<CategoryDto> categories) {
			this.categories = categories;
		}

		public List<AddressDto> getAddresses() {
			return addresses;
		}

		public void setAddresses(List<AddressDto> addresses) {
			this.addresses = addresses;
		}

		public List<ContactDto> getContacts() {
			return contacts;
		}

		public void setContacts(List<ContactDto> contacts) {
			this.contacts = contacts;
		}

		public boolean isDelete() {
			return delete;
		}

		public void setDelete(boolean delete) {
			this.delete = delete;
		}

		
	   
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
	    	
}