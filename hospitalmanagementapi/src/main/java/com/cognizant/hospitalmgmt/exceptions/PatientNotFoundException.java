package com.cognizant.hospitalmgmt.exceptions;

import java.io.Serializable;

public class PatientNotFoundException extends RuntimeException implements Serializable {
	public PatientNotFoundException(String message) {
		super(message);
	}

}
