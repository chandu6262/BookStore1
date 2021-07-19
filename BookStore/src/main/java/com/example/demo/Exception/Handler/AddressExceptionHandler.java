package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.AddressNotFoundException;
import com.example.demo.Exception.ErrorType;

@ControllerAdvice
public class AddressExceptionHandler {

	@ExceptionHandler(AddressNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> AddressNotFound(
			AddressNotFoundException expAddress) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expAddress.getMessage(), "Address details does not exist"), HttpStatus.NOT_FOUND);
	}
}
