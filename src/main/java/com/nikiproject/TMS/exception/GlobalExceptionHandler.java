package com.nikiproject.TMS.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nikiproject.TMS.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Map<String,String>>> handleValidationException(MethodArgumentNotValidException exception)
	{
		
		Map<String, String> errors= new HashMap<>();
		
		exception.getBindingResult()
			.getFieldErrors() 
			.forEach(error ->
					errors.put(error.getField(), error.getDefaultMessage()));
		
		ApiResponse<Map<String, String>> response = new ApiResponse<>(400, "Validation failed.",errors);
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ApiResponse<Void>> handleUserAlreadyExistException(UserAlreadyExistException exception)
	{
		
		ApiResponse<Void> response= new ApiResponse<>(409,exception.getMessage(),null);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleUserNotFoundException(UserNotFoundException exception)
	{
		
		ApiResponse<Void> response= new ApiResponse<>(404,exception.getMessage(),null);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
}
