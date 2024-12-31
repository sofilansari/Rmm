package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ids.argus.dto.UsersDto;
import com.ids.argus.model.Address;
import com.ids.argus.model.Contact;
import com.ids.argus.model.Task;
import com.ids.argus.model.Users;
import com.ids.argus.repo.AddressRepository;
import com.ids.argus.repo.ContactRepository;
import com.ids.argus.repo.TaskRepository;
import com.ids.argus.repo.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersServicesImpl implements UsersServices{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	


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
		
		 Users users = new Users();
	        users.setFirstName(usersDto.getFirstName());
	        users.setLastName(usersDto.getLastName());
	        users.setEmailId(usersDto.getEmailId());
	        users.setPassword(usersDto.getPassword());
	        users.setConfirmPassword(usersDto.getConfirmPassword());
	        users.setContact(usersDto.getContact());
	        users.setAddress(usersDto.getAddress());
	        users.setStates(usersDto.getStates());
	        users.setDelete(usersDto.isDelete());

	        // Save the User entity
	        Users savedUser = usersRepository.save(users);

	        if (usersDto.getTasks() != null) {
	            List<Task> tasks = usersDto.getTasks().stream().map(taskDto -> {
	                Task task = new Task();
	                task.setTaskName(taskDto.getTaskName());
	                task.setState(taskDto.isState());
	                task.setDelete(taskDto.isDelete());
	                task.setPractices(taskDto.isPractices());
	                task.setUsers(savedUser);
	                return taskRepository.save(task);
	            }).collect(Collectors.toList());
	            savedUser.setTasks(tasks);
	        }

	        if(usersDto.getAddress() !=null) {
	        	List<Address> addresses=usersDto.getAddresses().stream().map(addressDto ->{
	        		Address address=new Address();
	        		address.setType(addressDto.getType());
	        		address.setCity(addressDto.getCity());
	        		address.setState(addressDto.getState());
	        		address.setZipcode(addressDto.getZipcode());
	        		address.setDeleted(addressDto.isDeleted());
	        		address.setUsers(savedUser);
	        		
	        		return addressRepository.save(address);
	        	}).collect(Collectors.toList());
	        	savedUser.setAddresses(addresses);
	        }
	        
	       if(usersDto.getContacts() !=null) {
	    	   List<Contact>contacs=usersDto.getContacts().stream().map(contactDto -> {
	    		   Contact contact=new Contact();
	    		   contact.setType(contactDto.getType());
	    		   contact.setPhoneNo(contactDto.getPhoneNo());
	    		   contact.setDeleted(contactDto.isDeleted());
	    		   contact.setUsers(savedUser);
	    		   return contactRepository.save(contact);
	    	   }).collect(Collectors.toList());
	    	   savedUser.setContacts(contacs);
	       }
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
