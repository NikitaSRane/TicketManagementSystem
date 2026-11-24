package com.nikiproject.TMS.service.impl;

import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nikiproject.TMS.dto.user.CreateUserRequest;
import com.nikiproject.TMS.dto.user.UserResponse;
import com.nikiproject.TMS.enums.UserStatus;
import com.nikiproject.TMS.exception.UserAlreadyExistException;
import com.nikiproject.TMS.model.User;
import com.nikiproject.TMS.repository.UserRepository;
import com.nikiproject.TMS.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public UserResponse createUser(CreateUserRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail()))
		{
			throw new UserAlreadyExistException("User is alredy exist with this email "+request.getEmail());
		}
		
		User user= new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setDepartment(request.getDepartment());
		user.setRole(request.getRole());
		user.setStatus(UserStatus.ACTIVE);
		
		User savedUser=userRepository.save(user);	
		return mapToResponse(savedUser);
	}
	
	public List<UserResponse> getAllUsers()
	{
		return userRepository.findAll()
		.stream().map(this::mapToResponse)
		.toList();
	}
	
	private UserResponse mapToResponse(User user)
	{
		UserResponse response=new UserResponse();
		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		response.setDepartment(user.getDepartment());
		response.setStatus(user.getStatus());
		response.setCreatedAt(user.getCreatedAt());
		response.setUpdatedAt(user.getUpdatedAt());
		return response;
	}
	
	
}
