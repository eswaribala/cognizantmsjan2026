package com.cognizant.hospitalmgmt.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.hospitalmgmt.controllers.PatientController;
import com.cognizant.hospitalmgmt.mappers.PatientMapper;
import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Gender;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.services.PatientService;
import com.github.javafaker.Faker;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	@MockBean
	private PatientService patientService;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PatientMapper patientMapper; 
	@Test
	public void testGetAllPatients() throws Exception {
		List<Patient> patients = getAllPatients();
		Mockito.when(patientService.getAllPatients()).thenReturn(patients);
		 mockMvc.perform(get("/patients/v1.0")
		            .with(jwt().authorities(() -> "SCOPE_developer")))
		        .andExpect(status().isOk());
		
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
