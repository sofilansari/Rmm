package com.ids.argus.services;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.RegisterRequest;
import com.ids.argus.dto.UserDto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServicesImpl implements UserServices{
	
	

	@Override
	public UserDto registerUser(RegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto loginUser(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
