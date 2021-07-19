package com.example.demo.Exception;

public class PublisherNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PublisherNotFoundException() {
		super();
	}

	public PublisherNotFoundException(String message) {
		super(message);
	}

}
