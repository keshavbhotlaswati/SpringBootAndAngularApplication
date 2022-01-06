package com.springboot.employee.employee.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private String message;
	
	
	
	
	public ExceptionResponse( String message) {
		super();
		
		this.message = message;
	
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
	
	
}
