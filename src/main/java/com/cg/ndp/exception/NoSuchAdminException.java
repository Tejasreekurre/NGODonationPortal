package com.cg.ndp.exception;

public class NoSuchAdminException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchAdminException(String errorMessage) {
		super(errorMessage);
	}

}
