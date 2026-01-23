package com.cognizant.hospitalmgmt.dtos;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class DoctorDTO extends PersonDTO implements Serializable {	
	private String licenseNumber;	
	private String specialization;		
	private String qualification;

}
