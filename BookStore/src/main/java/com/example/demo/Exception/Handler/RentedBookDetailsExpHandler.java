package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.ErrorType;
import com.example.demo.Exception.RentedBookDetailsNotFoundExp;

@ControllerAdvice
public class RentedBookDetailsExpHandler {
	@ExceptionHandler(RentedBookDetailsNotFoundExp.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> detailsNotFound(
			RentedBookDetailsNotFoundExp expDetails) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expDetails.getMessage(), "Rented Book details does not exist"), HttpStatus.NOT_FOUND);
	}
}
