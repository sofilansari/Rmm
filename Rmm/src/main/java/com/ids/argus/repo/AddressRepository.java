package com.ids.argus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
