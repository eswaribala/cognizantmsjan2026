package com.cognizant.hospitalmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.hospitalmgmt.models.Patient;

@Controller
public class PatientController {
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		System.out.println("Patient Details: " + patient);
		// Logic to save patient details
		return "patientStatus";
	}

}
