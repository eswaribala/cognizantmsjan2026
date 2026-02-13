package com.cognizant.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ecommerce.dtos.PatientResponse;
import com.cognizant.ecommerce.services.CBService;

@RestController
@RequestMapping("/cbs")
public class CBController {
	@Autowired
	private CBService cbService;
	@GetMapping("/v1.0")
	public ResponseEntity<List<PatientResponse>> getData() {
		// Call service method to get data
		return cbService.getData();
	}

}
