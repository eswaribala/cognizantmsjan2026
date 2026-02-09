package com.cognizant.ecommerce.exceptions;

public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException(String message) {
		super(message);
	}

}
