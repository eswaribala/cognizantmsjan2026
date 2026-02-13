package com.cognizant.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.cognizant.ecommerce.dtos.PatientResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CBServiceImpl implements CBService {
	@Autowired
	private RestClient restClient;
	@Value("${gatewayUrl}")
	private String gatewayUrl;
	@Value("${serviceUrl}")
	private String serviceUrl;
	@Value("${alternativeServiceUrl}")
	private String alternativeServiceUrl;

	@Override
	@CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "fallback")
    @Retry(name = "gatewayRetry")
    @RateLimiter(name="gatewayRateLimiter")
	public ResponseEntity<List<PatientResponse>> getData() {
		 String token=restClient.get().uri(gatewayUrl).retrieve()
				 .body(String.class); 	
		 System.out.println(token);	
		// Attach token to REST call using headers()
		 List<PatientResponse> responses = restClient.get()
		         .uri(serviceUrl)
		         .headers(headers -> headers.setBearerAuth(token))
		         .retrieve()
		         .body(new ParameterizedTypeReference<List<PatientResponse>>() {});
         return ResponseEntity.ok(responses);
		 
	}
	
	public ResponseEntity<String> fallback(Exception ex) {
		log.warn("Fallback method invoked due to: " + ex.getMessage());
		String response=restClient.get()
		         .uri(alternativeServiceUrl)
		         .retrieve()
		         .body(new ParameterizedTypeReference<String>() {});
		 return ResponseEntity.ok(response);
	}

}
