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
	public ResponseEntity<FeedException> handlerFeedException (FeedException ex){
	
		return new ResponseEntity<FeedException>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<IOException> handlerIOException (IOException ex){
		return new ResponseEntity<IOException>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
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
