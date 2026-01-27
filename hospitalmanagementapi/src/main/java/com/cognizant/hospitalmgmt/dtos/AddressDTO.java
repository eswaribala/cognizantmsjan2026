package com.cognizant.hospitalmgmt.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	
	
	
	private String houseNumber;
	
	private String streetName;

	private String city;

	private String state;
	
	private String zipCode;
	//private PersonDTO person;

}
