package com.ids.argus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
