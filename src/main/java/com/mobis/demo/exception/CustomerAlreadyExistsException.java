package com.mobis.demo.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

	
	public CustomerAlreadyExistsException(String message, Throwable throwable) {
		super(message, throwable);
		
	}

	
	
	
	
	

}
