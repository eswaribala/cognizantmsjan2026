package com.cognizant.hospitalmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.cognizant.hospitalmgmt.models.Patient;

@Controller
public class PatientController {
	@Autowired
	private RestClient restClient;
	@Value("${apiUrl}")
	private String patientServiceUrl;// Example URL
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		System.out.println("Patient Details: " + patient);
		// Logic to save patient details
		//api call to save patient
		String response=restClient.post().uri(patientServiceUrl).body(patient)
		.retrieve().body(String.class);
		System.out.println("Response from Patient Service: " + response);
		return "patientStatus";
	}

}
