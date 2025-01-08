package com.ids.argus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ids.argus.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findByStatus(boolean status);

}
