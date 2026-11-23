package com.nikiproject.TMS.dto.user;

import com.nikiproject.TMS.enums.UserRole;
import com.nikiproject.TMS.enums.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
	
	@NotBlank(message= "First Name is required.")
	@Size(max = 100, message = "First Name cannot exceed 100 characters.")
	private String firstName;
	
	@NotBlank(message= "Last Name is required.")
	@Size(max = 100, message = "Last Name cannot exceed 100 characters.")
	private String lastName;
	
	@NotBlank(message= "Email is required.")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message= "Password is required.")
	@Size(min = 6, message = "Password must contains 6 characters")
	private String password;
	
	@NotNull(message= "Role is required.")
	private UserRole role;
	
	private UserStatus status;
	
	@NotBlank(message= "Department is required.")
	private String department;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
