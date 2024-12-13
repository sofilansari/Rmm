package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.AddressDto;

public interface AddressServices {

	public List<AddressDto> getAllAddress();

	public AddressDto findById(Long id);

	public AddressDto create(AddressDto addressDto);

	public AddressDto update(Long id, AddressDto addressDto);

	public void delete(Long id);

}
