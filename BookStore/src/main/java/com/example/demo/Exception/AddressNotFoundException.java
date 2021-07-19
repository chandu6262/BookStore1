package com.example.demo.Exception;

public class AddressNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

}
