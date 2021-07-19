package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.AuthorNotFoundException;
import com.example.demo.Exception.ErrorType;

@ControllerAdvice
public class AuthorExceptionHandler {

	@ExceptionHandler(AuthorNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> AuthorNotFound(
			AuthorNotFoundException expAuthor) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expAuthor.getMessage(), "Author details does not exist"), HttpStatus.NOT_FOUND);
	}
}
