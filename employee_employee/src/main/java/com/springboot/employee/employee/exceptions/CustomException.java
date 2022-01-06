package com.springboot.employee.employee.exceptions;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomException extends ResponseEntityExceptionHandler {
	
	

//@ExceptionHandler(EmployeeNotFoundException.class)	
//public final ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex,WebRequest request){
//	
//	ExceptionResponse exceptionresponse=new ExceptionResponse("Employee or Employee Manager Not Found .please check");
//	
//	
//	return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
//}
	
	
@ResponseStatus(HttpStatus.CREATED)
public final ResponseEntity<Object> handleCreateEmployeeDetails(Exception ex,WebRequest request){
	
	ExceptionResponse exceptionresponse=new ExceptionResponse("Employee Details has been created successfully");
	
	
	return new ResponseEntity(exceptionresponse,HttpStatus.CREATED);
	
}
	
@ResponseStatus(HttpStatus.NOT_FOUND)
public final ResponseEntity<Object> handleNotFoundException(Exception ex,WebRequest request){
	
	ExceptionResponse exceptionresponse=new ExceptionResponse("Employee or user Not Found .please check");
	
	
	return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
}




}
