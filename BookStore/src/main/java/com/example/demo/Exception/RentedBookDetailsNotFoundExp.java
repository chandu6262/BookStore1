package com.example.demo.Exception;

public class RentedBookDetailsNotFoundExp extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RentedBookDetailsNotFoundExp() {
		super();
	}

	public RentedBookDetailsNotFoundExp(String message) {
		super(message);
	}

}
