package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.ErrorType;
import com.example.demo.Exception.PublisherNotFoundException;

@ControllerAdvice
public class PublisherExceptionHandler {
	@ExceptionHandler(PublisherNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> publisherNotFound(
			PublisherNotFoundException expPublisher) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expPublisher.getMessage(), "Publisher details does not exist"), HttpStatus.NOT_FOUND);
	}
}
