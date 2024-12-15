package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.ContactDto;

public interface ContactServices {

	public List<ContactDto> getAllContct();

	public ContactDto findById(Long id);

	public ContactDto create(ContactDto contactDto);

	public ContactDto update(Long id, ContactDto contactDto);

	public void delete(Long id);

}
