package com.lingua.exception;

public class UserException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public UserException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public UserException() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	
}
