package com.cg.ndp.exception;

public class DuplicateNeedyPersonException extends Exception {
private static final long serialVersionUID = 1L;
	
	public DuplicateNeedyPersonException(String errorMessage) {
		super(errorMessage);
	}


}
