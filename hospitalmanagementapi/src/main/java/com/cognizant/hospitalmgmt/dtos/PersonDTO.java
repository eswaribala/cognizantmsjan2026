package com.cognizant.hospitalmgmt.dtos;
import java.io.Serializable;
import java.time.LocalDate;

import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder

public abstract class PersonDTO implements Serializable {
	
	private String adharCardNo;
	
	private FullName fullName;
	
	private Gender gender;

	private LocalDate dateOfBirth;

	private long contactNumber;
	
	private String email;	
 
}
