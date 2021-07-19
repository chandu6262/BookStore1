package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Exception.ErrorType;
import com.example.demo.Exception.UserNotFoundException;


@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> handleEmpNotFoundEx(
			UserNotFoundException ex) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(ex.getMessage(), "User details does not exist"), HttpStatus.NOT_FOUND);
	}
	
}
