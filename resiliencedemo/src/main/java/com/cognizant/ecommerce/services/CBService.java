package com.cognizant.ecommerce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cognizant.ecommerce.dtos.PatientResponse;

public interface CBService {

	ResponseEntity<List<PatientResponse>> getData();
}
