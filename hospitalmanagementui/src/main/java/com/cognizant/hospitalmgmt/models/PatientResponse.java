package com.cognizant.hospitalmgmt.models;

import java.time.LocalDate;

import com.cognizant.hospitalmgmt.models.Gender;

public record PatientResponse(String adharCardNo, 
		FullNameResponse fullNameResponse,String email,
		Gender gender,LocalDate dob,long 
		contactNo,String ailment,String occupation) {

}
