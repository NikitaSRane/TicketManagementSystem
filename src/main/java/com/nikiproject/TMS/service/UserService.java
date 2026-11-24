package com.nikiproject.TMS.service;

import java.util.List;
import com.nikiproject.TMS.dto.user.CreateUserRequest;
import com.nikiproject.TMS.dto.user.UserResponse;

public interface UserService {
	public UserResponse createUser(CreateUserRequest request);

	public List<UserResponse> getAllUsers();

	public UserResponse getUserById(Long id);
}
