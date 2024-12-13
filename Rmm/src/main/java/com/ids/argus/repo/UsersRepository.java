package com.ids.argus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
