package com.cognizant.hospitalmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.hospitalmgmt.models.FullName;
import com.cognizant.hospitalmgmt.models.Patient;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		Patient patient = new Patient();
		patient.setFullName(new FullName()); 
		model.addAttribute("patient", patient);
		return "home";
	}

}
