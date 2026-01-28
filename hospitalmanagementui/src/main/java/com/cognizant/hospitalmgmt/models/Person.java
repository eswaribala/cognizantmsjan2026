package com.cognizant.hospitalmgmt.models;
import java.io.Serializable;
import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder

public abstract class Person implements Serializable {
	
	
	private FullName fullName;
	
	private Gender gender;

	private LocalDate dateOfBirth;

	private long contactNumber;
	private String email;	
 
}
