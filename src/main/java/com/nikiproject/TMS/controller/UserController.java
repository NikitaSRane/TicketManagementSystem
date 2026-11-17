package com.nikiproject.TMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikiproject.TMS.dto.user.CreateUserRequest;
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
}
