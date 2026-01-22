package com.cognizant.hospitalmgmt.services;

import java.util.List;

import com.cognizant.hospitalmgmt.models.Patient;

public interface PatientService {
	
     Patient addPatient(Patient patient);
     List<Patient> getAllPatients();
     Patient getPatientByAdharCardNo(String adharCardNo);
     List<Patient> getPatientByPhoneNumber(long contactNumber);
     Patient getPatientByEmail(String email);
     Patient updatePatient(String adharCardNo, long phoneNumber, String email);
     boolean deletePatient(String adharCardNo);

}
