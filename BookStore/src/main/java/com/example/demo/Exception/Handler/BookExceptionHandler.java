package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Exception.ErrorType;

@ControllerAdvice
public class BookExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> BookNotFound(
			BookNotFoundException expBook) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expBook.getMessage(), "Book details does not exist"), HttpStatus.NOT_FOUND);
	}
}
