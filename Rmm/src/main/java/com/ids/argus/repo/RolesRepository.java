package com.ids.argus.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{
	
<<<<<<< HEAD
	Optional<Roles>findByName(String name);
=======
	Optional<Roles>findByRolesName(String rolesName);
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44

}
