package com.springboot.project.digitalLibrary.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(
			                                  ResourceNotFoundException exception ){
		
		ErrorResponse error = ErrorResponse.builder().
				              status(HttpStatus.NOT_FOUND.value()).
				              message(exception.getMessage()).
				              dateTime(LocalDateTime.now()).
				              build();
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(
			MissingServletRequestParameterException exception){
		
		ErrorResponse error = ErrorResponse.builder().
	                status(HttpStatus.BAD_REQUEST.value()).
	                message("Parameter is missing : "+exception.getParameterName()).
	                dateTime(LocalDateTime.now()).
	                build();
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception ){
		
		ErrorResponse error = ErrorResponse.builder().
                              status(HttpStatus.BAD_REQUEST.value()).
                              message(exception.getMessage()).
                              dateTime(LocalDateTime.now()).
                              build();
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
