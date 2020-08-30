package com.frmt.rsshottopics.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rometools.rome.io.FeedException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> handlerFeedException (FeedException ex){
	
		ExceptionMessage error = new ExceptionMessage();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ExceptionMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> handlerIOException (IOException ex){
		
		ExceptionMessage error = new ExceptionMessage();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ExceptionMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> handlerFeedException (com.frmt.rsshottopics.exception.FeedException ex){
		
		ExceptionMessage error = new ExceptionMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ExceptionMessage>(error,HttpStatus.BAD_REQUEST);
	}
}
