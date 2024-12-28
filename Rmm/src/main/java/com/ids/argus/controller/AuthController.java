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

    // Register user
    @PostMapping("/signup")
<<<<<<< HEAD
    public ResponseEntity<UserDto> registerUser(@RequestBody RegisterRequest registerRequest) {
        UserDto userDto = userServices.registerUser(registerRequest);
        return ResponseEntity.ok(userDto);
=======
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userServices.registerUser(userDto);
        return ResponseEntity.ok(userDto1);  
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
    }

    // Login user and generate JWT token
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDto userDto = userServices.loginUser(loginRequest);

<<<<<<< HEAD
        if (userDto == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        // Generate JWT token
        String token = JwtUtil.generateToken(userDto.getEmailId());

        // Return token and user information
        JwtResponse jwtResponse = new JwtResponse(token, userDto);
        return ResponseEntity.ok(jwtResponse);
=======
        String token = JwtUtil.generateToken(userDto.getEmailId());
        return ResponseEntity.ok(new JwtResponse(token, userDto));
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
    }
}
