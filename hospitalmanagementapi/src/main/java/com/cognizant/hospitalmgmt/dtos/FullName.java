package com.cognizant.hospitalmgmt.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName {
	
	private String firstName;
	
	private String lastName;

}
