package com.cognizant.hospitalmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.hospitalmgmt.dtos.GenericMessage;
import com.cognizant.hospitalmgmt.dtos.PatientDTO;
import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
	private PatientService patientService;
    
    @PostMapping("/v1.0")
    public ResponseEntity<GenericMessage> addPatient(@RequestBody PatientDTO patientDTO) {
		//mapping DTO to entity
    	FullName fullName=FullName.builder()
    			.firstName(patientDTO.getFullName().getFirstName())
    			.lastName(patientDTO.getFullName().getLastName())
    			.build();
    	
    	  	Patient patient=Patient.builder()
    			.adharCardNo(patientDTO.getAdharCardNo()) 
    			.fullName(fullName)
    			.contactNumber(patientDTO.getContactNumber())
				.dateOfBirth(patientDTO.getDateOfBirth())
				.email(patientDTO.getEmail())
				.ailment(patientDTO.getAilment())
				.gender(patientDTO.getGender())
				.occupation(patientDTO.getOccupation())			    
    			.build();
    	 Patient patientResponse=patientService.addPatient(patient);
    	 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(new GenericMessage("Patient added successfully with Adhar Card No: "
    	 +patientResponse.getAdharCardNo(),null));
	}
    
    
}
