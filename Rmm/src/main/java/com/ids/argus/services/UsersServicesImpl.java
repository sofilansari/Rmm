package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.UsersDto;
import com.ids.argus.model.Users;
import com.ids.argus.repo.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersServicesImpl implements UsersServices{
	
	private final UsersRepository usersRepository;

	public UsersServicesImpl(UsersRepository usersRepository) {
		
		this.usersRepository = usersRepository;
	}

	@Override
	public List<UsersDto> gettAllUser() {
		List<Users>usersOfList=usersRepository.findAll();
		return usersOfList.stream().map(users -> new UsersDto().toDo(users))
				.collect(Collectors.toList());
	}
	
	

}
