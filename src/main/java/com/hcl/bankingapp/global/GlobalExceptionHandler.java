package com.hcl.bankingapp.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.bankingapp.exception.EnterValidCredentials;
import com.hcl.bankingapp.exception.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(UserNotFound ex, WebRequest request) {
     
		ExceptionPojo user = new ExceptionPojo(ex.getMessage());

		return new ResponseEntity<ExceptionPojo>(user, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EnterValidCredentials.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(EnterValidCredentials ex, WebRequest request) {
     
		ExceptionPojo user = new ExceptionPojo(ex.getMessage());

		return new ResponseEntity<ExceptionPojo>(user, HttpStatus.NOT_FOUND);
	}

}
