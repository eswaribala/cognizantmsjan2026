package com.cognizant.hospitalmgmt.dtos;
import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.cognizant.hospitalmgmt.models.Gender;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder

public abstract class PersonDTO implements Serializable {
	
	@Length(min = 12, max = 12, message = "Adhar Card Number must be 12 digits")
	private String adharCardNo;
	
	private FullName fullName;
	
	private Gender gender;

	private LocalDate dateOfBirth;

	private long contactNumber;
	
	private String email;	
 
}
