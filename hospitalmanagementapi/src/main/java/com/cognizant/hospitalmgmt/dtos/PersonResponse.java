package com.cognizant.hospitalmgmt.dtos;

import java.time.LocalDate;

import com.cognizant.hospitalmgmt.models.Gender;

public record PersonResponse(String adharCardNo, 
		FullNameResponse fullNameResponse,String email,
		Gender gender,LocalDate dob,long 
		contactNo) {

}
