package com.cognizant.hospitalmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.cognizant.hospitalmgmt.models.GenericMessage;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.models.PatientResponse;
import com.cognizant.hospitalmgmt.models.TokenReceiver;

@Controller
public class PatientController {
	@Autowired
	private RestClient restClient;
	@Value("${apiUrl}")
	private String patientServiceUrl;// Example URL
	@Value("${gatewayUrl}")
	private String gatewayUrl;
	@Value("${role}")
	private String role;
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, Model model) {
		System.out.println("Patient Details: " + patient);
		String token=restClient.get().uri(gatewayUrl+role).retrieve()
				 .body(String.class);
		// Logic to save patient details
		//api call to save patient
		GenericMessage<PatientResponse> message=restClient.post()
				.uri(patientServiceUrl).body(patient)
				.headers(headers -> headers.setBearerAuth(token))
		.retrieve().body(new ParameterizedTypeReference<GenericMessage<PatientResponse>>() {});
		PatientResponse response=(PatientResponse) message.getObject();
		System.out.println("Response from Patient Service: " + response);
		model.addAttribute("response", response);
		return "patientStatus";
	}
	@GetMapping("/showPatients")
	public String showPatients(Model model) {
	 String token=restClient.get().uri(gatewayUrl+role).retrieve()
			 .body(String.class); 	
	 System.out.println(token);	
	// Attach token to REST call using headers()
	 List<PatientResponse> responses = restClient.get()
	         .uri(patientServiceUrl)
	         .headers(headers -> headers.setBearerAuth(token))
	         .retrieve()
	         .body(new ParameterizedTypeReference<List<PatientResponse>>() {});

	 model.addAttribute("patients", responses);
		return "showPatients";	
		
	}

}
