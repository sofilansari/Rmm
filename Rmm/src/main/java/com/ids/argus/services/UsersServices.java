package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.UsersDto;

public interface UsersServices {

	public List<UsersDto> gettAllUser();

	public UsersDto findById(Long id);

	public UsersDto create(UsersDto usersDto);

	public UsersDto update(Long id, UsersDto usersDto);

	public void delete(Long id);

}
