package com.cognizant.hospitalmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.cognizant.hospitalmgmt.models.GenericMessage;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.models.PatientResponse;

@Controller
public class PatientController {
	@Autowired
	private RestClient restClient;
	@Value("${apiUrl}")
	private String patientServiceUrl;// Example URL
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, Model model) {
		System.out.println("Patient Details: " + patient);
		// Logic to save patient details
		//api call to save patient
		GenericMessage<PatientResponse> message=restClient.post().uri(patientServiceUrl).body(patient)
		.retrieve().body(new ParameterizedTypeReference<GenericMessage<PatientResponse>>() {});
		PatientResponse response=(PatientResponse) message.getObject();
		System.out.println("Response from Patient Service: " + response);
		model.addAttribute("response", response);
		return "patientStatus";
	}
	
	public String showPatients(Model model) {
	 List<PatientResponse>	responses=restClient.get().uri(patientServiceUrl)
		.retrieve().body(new ParameterizedTypeReference<List<PatientResponse>>() {});
	 model.addAttribute("patients", responses);
		return "showPatients";	
		
	}

}
