package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.RolesDto;

public interface RolesServices {

	public List<RolesDto> getAllRoles();

	public RolesDto findById(Long id);

	public RolesDto crete(RolesDto rolesDto);

	public RolesDto update(Long id, RolesDto rolesDto);

	public void delete(Long id);

}
