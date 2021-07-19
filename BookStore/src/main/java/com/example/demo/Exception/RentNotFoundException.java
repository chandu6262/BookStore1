package com.example.demo.Exception;

public class RentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RentNotFoundException() {
		super();
	}

	public RentNotFoundException(String message) {
		super(message);
	}

}
