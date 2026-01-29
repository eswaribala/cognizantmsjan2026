package com.cognizant.hospitalmgmt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class GenericMessage<T> {
	private T object;
	private String message;
	
	public GenericMessage(T object) {
		super();
		this.object = object;
		
	}
	
	public GenericMessage(String message) {
		super();
		this.message = message;
		
	}
}
