package com.ids.argus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ids.argus.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
    @Query(value = "SELECT * FROM doctor WHERE status = :status", nativeQuery = true)
	List<Doctor> findByStatus(boolean status);

}
