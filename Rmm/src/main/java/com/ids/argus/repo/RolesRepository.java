package com.ids.argus.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{
	
 Optional<Roles>findByRolesName(String rolesName);

}
