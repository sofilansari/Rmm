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

	@Override
	public UsersDto findById(Long id) {
		Users users=usersRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Users not found with ID"+id));
		return new UsersDto().toDo(users);
	}

	@Override
	public UsersDto create(UsersDto usersDto) {
		
		Users users=new Users();
		users.setId(usersDto.getId());
		users.setFirstName(usersDto.getFirstName());
		users.setLastName(usersDto.getLastName());
		users.setEmailId(usersDto.getEmailId());
		users.setPassword(usersDto.getPassword());
		users.setConfirmPassword(usersDto.getConfirmPassword());
		users.setContact(usersDto.getContact());
		users.setAddress(usersDto.getAddress());
		users.setStates(usersDto.getStates());
		users.setDelete(usersDto.isDelete());
		
		Users savedUser=usersRepository.save(users);
		
		return new UsersDto().toDo(savedUser);
	}

	@Override
	public UsersDto update(Long id, UsersDto usersDto) {
		
		Users existingUsers=usersRepository.findById(id).
				orElseThrow(()-> new RuntimeException("Users not found with id"+ id));
		
		existingUsers.setId(usersDto.getId());
		existingUsers.setFirstName(usersDto.getFirstName());
		existingUsers.setLastName(usersDto.getLastName());
		existingUsers.setEmailId(usersDto.getEmailId());
		existingUsers.setConfirmPassword(usersDto.getConfirmPassword());
		existingUsers.setContact(usersDto.getContact());
		existingUsers.setAddress(usersDto.getAddress());
		existingUsers.setStates(usersDto.getStates());
		existingUsers.setDelete(usersDto.isDelete());
		
		Users saveUsers=usersRepository.save(existingUsers);
		
		return new UsersDto().toDo(saveUsers);
	}

	@Override
	public void delete(Long id) {
	
	Users deleteUsers=usersRepository.findById(id).
			orElseThrow(()-> new RuntimeException("Users not found with id"+ id));
	
	usersRepository.delete(deleteUsers);
	}
	
	

}
