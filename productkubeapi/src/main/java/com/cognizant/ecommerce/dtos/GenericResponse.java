package com.cognizant.ecommerce.dtos;

import lombok.Getter;

@Getter
public class GenericResponse<T> {
	private String message;
	private T data;
	
	public GenericResponse(String message) {
		this.message = message;
		
	}
	public GenericResponse(T data) {
	
		this.data = data;
	}

	

}
