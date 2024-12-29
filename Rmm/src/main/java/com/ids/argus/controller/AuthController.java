package com.ids.argus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.JwtResponse;
import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.UserDto;
import com.ids.argus.security.JwtUtil;
import com.ids.argus.services.UserServices;
@RestController
@RequestMapping("/api")
public class AuthController {
	
	private final UserServices userServices;

    public AuthController(UserServices userServices) {
        this.userServices = userServices;
    }

 
    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userServices.registerUser(userDto);
        return ResponseEntity.ok(userDto1);  
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDto userDto = userServices.loginUser(loginRequest);

        if (userDto == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        String token = JwtUtil.generateToken(userDto.getEmailId());

        JwtResponse jwtResponse = new JwtResponse(token, userDto);
        return ResponseEntity.ok(jwtResponse);
        
    }
}
