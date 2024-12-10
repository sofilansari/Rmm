package com.ids.argus.services;

import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.RegisterRequest;
import com.ids.argus.dto.UserDto;

public interface UserServices {

	public UserDto registerUser(RegisterRequest registerRequest);

	public UserDto loginUser(LoginRequest loginRequest);

}
