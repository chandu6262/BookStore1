package com.example.demo.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Exception.ErrorType;
import com.example.demo.Exception.OrderNotFoundException;

@ControllerAdvice
public class OrderExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseBody 
	public ResponseEntity<ErrorType> OrderNotFound(
			OrderNotFoundException expOrder) 
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(expOrder.getMessage(), "Order details does not exist"), HttpStatus.NOT_FOUND);
	}
}
