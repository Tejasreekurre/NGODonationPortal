package com.cg.ndp.exception;

public class DuplicateEmployeeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DuplicateEmployeeException(String errorMessage) {
		super(errorMessage);
	}

}
