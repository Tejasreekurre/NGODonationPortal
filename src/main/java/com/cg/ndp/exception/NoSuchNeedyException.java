package com.cg.ndp.exception;

public class NoSuchNeedyException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSuchNeedyException(String errorMessage) {
		super(errorMessage);
	}

}