package com.ids.argus.model;

import java.time.LocalDateTime;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public class BaseAuditable {
	
	   @OneToOne
	    @JoinColumn(name = "created_by_id")  // Column name adjusted for clarity
	    private Users createBy;

	    @OneToOne
	    @JoinColumn(name = "modified_by_id") // Column name adjusted for clarity
	    private Users modifiedBy;

	    private LocalDateTime createOn;
	    private LocalDateTime modifiedOn;

	    // Automatically set createOn when the entity is created
	    @PrePersist
	    protected void onCreate() {
	        this.createOn = LocalDateTime.now();
	    }

	    // Automatically set modifiedOn when the entity is updated
	    @PreUpdate
	    protected void onUpdate() {
	        this.modifiedOn = LocalDateTime.now();
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

	    public LocalDateTime getCreateOn() {
	        return createOn;
	    }

	    public void setCreateOn(LocalDateTime createOn) {
	        this.createOn = createOn;
	    }

	    public LocalDateTime getModifiedOn() {
	        return modifiedOn;
	    }

	    public void setModifiedOn(LocalDateTime modifiedOn) {
	        this.modifiedOn = modifiedOn;
	    }
}
