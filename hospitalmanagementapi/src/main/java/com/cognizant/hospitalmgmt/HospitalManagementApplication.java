package com.cognizant.hospitalmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}

}
