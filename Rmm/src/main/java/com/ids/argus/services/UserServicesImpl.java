package com.ids.argus.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ids.argus.dto.LoginRequest;
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

	    public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	        this.rolesRepository = rolesRepository;
	    }

	    @Override
	    public UserDto registerUser(UserDto userDto) {
	        
	       
	    	if (userRepository.findByEmailId(userDto.getEmailId()).isPresent()) {
	            throw new RuntimeException("Email is already registered");
	        }

	        User user = new User();
	        user.setUserName(userDto.getUserName());
	        user.setEmailId(userDto.getEmailId());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        user.setResetPassword(userDto.getResetPassword());
	        
	        Set<Roles> roles = userDto.getRoles().stream()
	                .map(rolesDto -> {
	                    Roles role = rolesRepository.findByRolesName(rolesDto.getRolesName())
	                            .orElseGet(() -> {
	                                Roles newRole = new Roles();
	                                newRole.setId(rolesDto.getId());
	                                newRole.setRolesName(rolesDto.getRolesName());
	                                return rolesRepository.save(newRole);
	                            });
	                    role.setUser(user);  
	                    return role;
	                })
	                .collect(Collectors.toSet());

	        
	        user.setRoles(roles);

	        User savedUser = userRepository.save(user);

	        return new UserDto().toDto(savedUser);
	    }

	    @Override
	    public UserDto loginUser(LoginRequest loginRequest) {
	        User user = userRepository.findByEmailId(loginRequest.getEmailId())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
	            throw new RuntimeException("Invalid credentials");
	        }

	        return new UserDto().toDto(user);  
	    }
}

