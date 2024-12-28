package com.ids.argus.services;

import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.UserDto;

public interface UserServices {

	public UserDto registerUser(UserDto userDto);

	public UserDto loginUser(LoginRequest loginRequest);

}
