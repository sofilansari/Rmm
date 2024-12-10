package com.ids.argus.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User>findByEmailId(String emailId);

}
