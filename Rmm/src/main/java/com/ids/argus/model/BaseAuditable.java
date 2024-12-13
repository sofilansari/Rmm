package com.ids.argus.model;

import java.util.Date;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public class BaseAuditable {
	
		@OneToOne
	    private Users createBy;

	    @OneToOne
	    private Users modifiedBy;

	    private Date createOn;

	    private Date modifiedOn;

	    @PrePersist
	    protected void onCreate() {
	        this.createOn = new Date(); // Automatically set current date on creation
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.modifiedOn = new Date(); // Automatically set current date on update
	    }

	    // Getters and Setters
	    public Users getCreateBy() {
	        return createBy;
	    }

	    public void setCreateBy(Users createBy) {
	        this.createBy = createBy;
	    }

	    public Users getModifiedBy() {
	        return modifiedBy;
	    }

	    public void setModifiedBy(Users modifiedBy) {
	        this.modifiedBy = modifiedBy;
	    }

	    public Date getCreateOn() {
	        return createOn;
	    }

	    public void setCreateOn(Date createOn) {
	        this.createOn = createOn;
	    }

	    public Date getModifiedOn() {
	        return modifiedOn;
	    }

	    public void setModifiedOn(Date modifiedOn) {
	        this.modifiedOn = modifiedOn;
	    }

}
