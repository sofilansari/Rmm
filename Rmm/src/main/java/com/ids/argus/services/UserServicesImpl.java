package com.ids.argus.services;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ids.argus.dto.LoginRequest;
import com.ids.argus.dto.RegisterRequest;
import com.ids.argus.dto.UserDto;
import com.ids.argus.model.Roles;
import com.ids.argus.model.User;
import com.ids.argus.repo.RolesRepository;
import com.ids.argus.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServicesImpl implements UserServices{
	
	    private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;
	    private final RolesRepository rolesRepository;

	    public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,RolesRepository rolesRepository) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	        this.rolesRepository=rolesRepository;
	    }

	    @Override
	    public UserDto registerUser(RegisterRequest registerRequest) {
	    	
	    	if(userRepository.findByEmailId(registerRequest.getEmailId()).isPresent()) {
	    		throw new RuntimeException("Email is already registered");
	    	}
	        
	        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

	        
	        User users = new User();
	        users.setUserName(registerRequest.getUserName());
	        users.setEmailId(registerRequest.getEmailId());
	        users.setPassword(encodedPassword);
	        users.setresetPassword(registerRequest.getresetPassword());
	        
	        Set<Roles> roles = registerRequest.getRoles().stream()
	                .map(role -> roleRepository.findByName(role.getRolesName())
	                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.getRolesName())))
	                .collect(Collectors.toSet());
	        user.setRoles(roles);

	        User savedUser = userRepository.save(users);

	        return new UserDto(savedUser.getPassword(), savedUser.getEmailId());
	    }

	    @Override
	    public UserDto loginUser(LoginRequest loginRequest) {
	        
	        User user = userRepository.findByEmailId(loginRequest.getEmailId())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        
	        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
	            throw new RuntimeException("Invalid credentials");
	        }

	        
	        return new UserDto(user.getEmailId(), user.getPassword());
	    }
}
