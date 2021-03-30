package com.cg.ndp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ndp.exception.DuplicateAdminException;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateEmployeeException;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchAdminException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.exception.NoSuchNeedyPeopleException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(value = {NoSuchNeedyPeopleException.class,NoSuchNeedyPeopleException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {DuplicateNeedyPersonException.class,DuplicateNeedyPersonException.class})
	public ResponseEntity<Object>  handleDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}

	
	@ExceptionHandler(value = {DuplicateDonationException.class,DuplicateDonationException.class})
	public ResponseEntity<Object>  handleDonationDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {NoSuchEmployeeException.class,NoSuchEmployeeException.class})
	public ResponseEntity<Object> handleNoEmployeeFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = {DuplicateAdminException.class,DuplicateAdminException.class})
	public ResponseEntity<Object>  handleAdminDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = {DuplicateEmployeeException.class,DuplicateEmployeeException.class})
	public ResponseEntity<Object>  handleEmployeeDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = {NoSuchAdminException.class,NoSuchAdminException.class})
	public ResponseEntity<Object> handleNoAdminFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
}
