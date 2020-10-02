package com.assetware.exception;

public class UserDetailExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailExistException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public UserDetailExistException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.getMessage() + super.getCause();
	}
	
	
}
