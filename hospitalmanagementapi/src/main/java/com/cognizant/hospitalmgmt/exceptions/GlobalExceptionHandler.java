package com.cognizant.hospitalmgmt.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GenericMessage>handleArgumentException(MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();
		Map<String, String> errors = new HashMap<>();
		String fieldName,errorMessage;
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			 fieldName = ((FieldError) error).getField().toString();
	         errorMessage = error.getDefaultMessage();
		});
		
	}
}
