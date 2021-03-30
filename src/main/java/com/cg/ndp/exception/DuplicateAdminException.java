package com.cg.ndp.exception;

public class DuplicateAdminException extends Exception {
private static final long serialVersionUID = 1L;
	
	public DuplicateAdminException(String errorMessage) {
		super(errorMessage);
	}

}
