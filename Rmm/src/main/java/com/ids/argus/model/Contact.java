package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact extends BaseAuditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String type;
    private String phoneNo;
    private boolean isDeleted;

//    @Version
//    private Long version;  // Version field for optimistic locking
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    public Contact() {
        super();
    }

    public Contact(Long id, String type, String phoneNo, boolean isDeleted,Doctor doctor) {
        super();
        this.id = id;
        this.type = type;
        this.phoneNo = phoneNo;
        this.isDeleted = isDeleted;
        this.doctor=doctor;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
	
	public Doctor setDoctor() {
		return doctor;
		
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor=doctor;
		
	}
}
