package com.ids.argus.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ids.argus.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query(value = "select * from users where status = :status", nativeQuery = true)
	List<Users> findByStatus(boolean status);


}
