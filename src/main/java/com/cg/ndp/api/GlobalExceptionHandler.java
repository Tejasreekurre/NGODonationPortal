package com.cg.ndp.api;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ndp.exception.DuplicateDonorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { DuplicateDonorException.class })
	public ResponseEntity<Object> handleDuplicateExceptions(Exception exp) {
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp) {
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	static String messageFrom(BindingResult result) {
		return result.getAllErrors().stream().map(err -> err.getObjectName() + "-" + err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}
}