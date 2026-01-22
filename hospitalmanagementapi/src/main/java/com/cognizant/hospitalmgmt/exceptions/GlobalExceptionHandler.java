package com.cognizant.hospitalmgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.hospitalmgmt.dtos.GenericMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PatientNullException.class)
	public ResponseEntity<GenericMessage> handlePatientNullException(PatientNullException ex) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new GenericMessage<>(null, ex.getMessage()));
	}

}
