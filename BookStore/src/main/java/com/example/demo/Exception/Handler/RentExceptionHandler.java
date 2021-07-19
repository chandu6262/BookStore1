package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.ErrorType;
import com.example.demo.Exception.RentNotFoundException;

@ControllerAdvice
public class RentExceptionHandler {

	@ExceptionHandler(RentNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> rentNotFound(
			RentNotFoundException expRent) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expRent.getMessage(), "Rent details does not exist"), HttpStatus.NOT_FOUND);
	}
	
}
