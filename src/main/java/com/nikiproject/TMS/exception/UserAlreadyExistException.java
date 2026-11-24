package com.nikiproject.TMS.exception;

public class UserAlreadyExistException extends RuntimeException{

	public UserAlreadyExistException(String message)
	{
		super(message);
	}
}
