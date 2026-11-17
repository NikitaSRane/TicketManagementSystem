package com.nikiproject.TMS.service;

import com.nikiproject.TMS.dto.user.CreateUserRequest;
import com.nikiproject.TMS.dto.user.UserResponse;

public interface UserService {
	public UserResponse createUser(CreateUserRequest request);
}
