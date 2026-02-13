package com.cognizant.ecommerce.dtos;

import java.time.LocalDate;

public record PatientResponse(String adharCardNo, 
		FullNameResponse fullNameResponse,String email,
		Gender gender,LocalDate dob,long 
		contactNo,String ailment,String occupation) {

}
