package com.cognizant.hospitalmgmt.services;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.hospitalmgmt.dtos.PatientResponse;
import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Gender;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.repositories.PatientRepository;
import com.github.javafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
	@InjectMocks 
	private PatientServiceImpl patientService;
	@Mock
	private PatientRepository patientRepository;
	// Add test methods here
	@Test
	public void testGetAllPatients() throws Exception {
		List<Patient> patients = getAllPatients();
		
		Mockito.when(patientRepository.findAll()).thenReturn(patients);
		List<Patient> patientResponses=patientService.getAllPatients();	
		assert(patientResponses.size() == patients.size());
		
	}
	@Test
	public void testAddPatientService() throws Exception {
		Patient patient = getAllPatients().get(0);
		
		Mockito.when(patientRepository.save(patient)).thenReturn(patient);
		Patient patientResponse=patientService.addPatient(patient);	
		assert(patientResponse.getAdharCardNo().equals(patient.getAdharCardNo()));
		
	}
	private List<Patient> getAllPatients() {
		Faker faker = new Faker();
		// TODO Auto-generated method stub
		List<Patient> patients = new ArrayList<>();
		for(int i=0;i<10;i++) {
			Patient patient = new Patient();
			patient.setAdharCardNo(faker.idNumber().valid());
			FullName name = new FullName();
			name.setFirstName(faker.name().firstName());
			name.setLastName(faker.name().lastName());
			patient.setFullName(name);
			patient.setContactNumber(faker.number().numberBetween(1000000000, 9999999999L));
			patient.setEmail(faker.internet().emailAddress());
			patient.setGender(getRandomGender());
			patient.setAilment(faker.medical().diseaseName());
			patient.setOccupation(faker.company().profession());
			patients.add(patient);
			
		}
		
		return patients;
	}
	
	private  Gender getRandomGender() {
		Gender[] genders=Gender.values();
		return genders[new Random().nextInt(genders.length)];
	}

}
