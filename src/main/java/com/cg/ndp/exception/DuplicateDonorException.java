package com.cg.ndp.exception;
public class DuplicateDonorException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateDonorException(String errorMessage) {
		super(errorMessage);

	}

}