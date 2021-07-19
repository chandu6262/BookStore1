package com.example.demo.Exception;

public class ErrorType {

	private String message;
	private String error;
	public ErrorType(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
