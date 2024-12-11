package com.ids.argus.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.RegisterRequest;
import com.ids.argus.dto.UserDto;
import com.ids.argus.model.User;
import com.ids.argus.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServicesImpl implements UserServices{
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	
	

	public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDto registerUser(RegisterRequest registerRequest) {
		String encodedPassword =passwordEncoder.encode(registerRequest.getPassword());
		
		User users=new User();
		
		users.setUseName(registerRequest.getUseName());
		users.setEmailId(registerRequest.getEmailId());
		users.setPassword(encodedPassword);
		users.setResetPaaword(registerRequest.getResetPaaword());
		
		User saveUser=userRepository.save(users);
		
		return new UserDto(saveUser.getPassword(), saveUser.getEmailId());
	}

	@Override
	public UserDto loginUser(LoginRequest loginRequest) {
		User user=userRepository.findByEmailId(loginRequest.getEmailId())
				.orElseThrow(() ->new RuntimeException("User not found"));
		if(!passwordEncoder.matches(loginRequest.getEmailId(), user.getEmailId())) {
			
			throw new RuntimeException("Invalid credentials");
		}
		
		return new UserDto(user.getEmailId(), user.getUseName());
	}

}
