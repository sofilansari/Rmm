package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.RolesDto;
import com.ids.argus.model.Roles;
import com.ids.argus.repo.RolesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolesServicesImpl implements RolesServices{
	
	private final RolesRepository repository;

	public RolesServicesImpl(RolesRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<RolesDto> getAllRoles() {
		List<Roles>rolesOfList=repository.findAll();
		return rolesOfList.stream().map(roles -> new RolesDto().toDto(roles)).
				collect(Collectors.toList());
	}

	@Override
	public RolesDto findById(Long id) {
		Roles roles=repository.findById(id).
				orElseThrow(() -> new RuntimeException("Roles not found with id"+ id));
		return new RolesDto().toDto(roles);
	}

	@Override
	public RolesDto crete(RolesDto rolesDto) {
		Roles savedRoles=new Roles();
		savedRoles.setId(rolesDto.getId());
		savedRoles.setRolesName(rolesDto.getRolesName());
		
		Roles saved=repository.save(savedRoles);
		return new RolesDto().toDto(saved);
	}

	@Override
	public RolesDto update(Long id, RolesDto rolesDto) {
		Roles exisitingRoles=repository.findById(id).
				orElseThrow(() -> new RuntimeException("Roles not found with id"+ id));
		
		exisitingRoles.setId(rolesDto.getId());
		exisitingRoles.setRolesName(rolesDto.getRolesName());
		
		Roles savedRoles=repository.save(exisitingRoles);
		return new RolesDto().toDto(savedRoles);
	}

	@Override
	public void delete(Long id) {
		Roles deleteRoles=repository.findById(id).
				orElseThrow(() -> new RuntimeException("Roles not found with is "+id));
		repository.delete(deleteRoles);
	}
	
	

}
