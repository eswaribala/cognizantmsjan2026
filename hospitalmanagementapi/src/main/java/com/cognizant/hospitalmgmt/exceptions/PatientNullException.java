package com.cognizant.hospitalmgmt.exceptions;

import java.io.Serializable;

public class PatientNullException extends RuntimeException implements Serializable {
	public PatientNullException(String message) {
		super(message);
	}

}
