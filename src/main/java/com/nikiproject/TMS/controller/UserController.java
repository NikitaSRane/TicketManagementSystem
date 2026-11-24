package com.nikiproject.TMS.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikiproject.TMS.dto.user.CreateUserRequest;
import com.nikiproject.TMS.dto.user.UpdateUserRequest;
import com.nikiproject.TMS.dto.user.UserResponse;
import com.nikiproject.TMS.response.ApiResponse;
import com.nikiproject.TMS.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userservice;
	
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	@PostMapping
	public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest request){
		UserResponse user = userservice.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201,"User created successfully.",user));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers()
	{
		List<UserResponse> response = userservice.getAllUsers();
		
		return ResponseEntity.ok( new ApiResponse<>(200,"Users fetched successfully", response));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id)
	{
		UserResponse response = userservice.getUserById(id);
		
		return ResponseEntity.ok( new ApiResponse<>(200,"Users fetched successfully", response));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> updateUser(@Valid @RequestBody UpdateUserRequest request ,@PathVariable Long id)
	{
		UserResponse response = userservice.updateUser(id,request);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"User updated successfully.",response));	}
	
}
