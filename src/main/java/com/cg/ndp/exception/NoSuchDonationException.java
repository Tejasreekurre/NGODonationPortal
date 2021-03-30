package com.cg.ndp.exception;

public class NoSuchDonationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchDonationException(String errorMessage) {
		super(errorMessage);
	}

}
