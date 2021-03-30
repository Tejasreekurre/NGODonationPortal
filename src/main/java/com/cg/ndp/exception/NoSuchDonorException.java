package com.cg.ndp.exception;

public class NoSuchDonorException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchDonorException(String errorMessage) {
		super(errorMessage);

	}
}