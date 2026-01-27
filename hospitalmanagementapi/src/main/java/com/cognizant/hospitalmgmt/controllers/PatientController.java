package com.cognizant.hospitalmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.hospitalmgmt.dtos.GenericMessage;
import com.cognizant.hospitalmgmt.dtos.PatientDTO;
import com.cognizant.hospitalmgmt.dtos.PatientResponse;
import com.cognizant.hospitalmgmt.mappers.PatientMapper;
import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.services.PatientService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
	private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;
    
    @PostMapping("/v1.0")
    public ResponseEntity<GenericMessage> addPatient(@Valid @RequestBody PatientDTO patientDTO) {
		//mapping DTO to entity
    	FullName fullName = FullName.builder()
				.firstName(patientDTO.getFullName().getFirstName())
				.lastName(patientDTO.getFullName().getLastName())
				.build();
    	Patient patient = Patient.builder()
    			
    			.fullName(fullName)
    			.dateOfBirth(patientDTO.getDateOfBirth())
    			.email(patientDTO.getEmail())
    			.contactNumber(patientDTO.getContactNumber())
    			.gender(patientDTO.getGender())
    			.ailment(patientDTO.getAilment())
    			.occupation(patientDTO.getOccupation())
    			.build();
    	Patient savedPatient = patientService.addPatient(patient);
    	PatientResponse patientResponse = patientMapper.toDTOs(savedPatient);
    	return ResponseEntity.status(HttpStatus.CREATED)
				.body(new GenericMessage("Patient added successfully with Adhar Card No: " 
    	+patientResponse,null));
	}
    @GetMapping("/v1.0")
    public List<PatientResponse> getAllPatients() {
    	List<Patient> patients=	patientService.getAllPatients();
    	List<PatientResponse> patientResponses = patientMapper.toDTOs(patients);
    	return patientResponses;
    	
    }
    
    @GetMapping("/v1.0/{adharCardNo}")
	public ResponseEntity<GenericMessage> getPatientByAdharCardNo(@PathParam("adharCardNo") String adharCardNo) {
		
		Patient patient = patientService.getPatientByAdharCardNo(adharCardNo);
		PatientResponse patientResponse = patientMapper.toDTOs(patient);
    	return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new GenericMessage("Patient Retrieved successfully with Adhar Card No: " 
    	+ patientResponse,null));
	}
    
    @PatchMapping("/v1.0")
    public ResponseEntity<GenericMessage> updatePatientByEmailAndPhoneNumber(
    		@RequestParam String adharCardNo,
    		@RequestParam long contactNo,@RequestParam String email) {
    		Patient updatedPatient = patientService.updatePatient(adharCardNo, contactNo, email);
    	    PatientResponse patientResponse = patientMapper.toDTOs(updatedPatient);
    		return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new GenericMessage("Patient updated successfully with Adhar Card No: " 
			+ patientResponse,null));
    }
    
    @DeleteMapping("/v1.0")
    public ResponseEntity<GenericMessage> deletePatientByAdharCardNo(
			@RequestParam String adharCardNo) {
			boolean isDeleted = patientService.deletePatient(adharCardNo);
			if(isDeleted) {
			    return ResponseEntity.status(HttpStatus.ACCEPTED)
						.body(new GenericMessage("Patient deleted successfully with Adhar Card No: " 
				+ adharCardNo,null));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new GenericMessage("Patient not found with Adhar Card No: " 
				+ adharCardNo,null));
			}
	}
    
}
