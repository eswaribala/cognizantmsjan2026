package com.cognizant.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.models.Repository;
import com.github.javafaker.Faker;

@Service
public class DBService {
	@Autowired
	private Repository repository;
	private Faker faker;
	
	public Repository getRepositoryDetails() {
		faker = new Faker();
		repository.setIpAddress(faker.internet().ipV4Address());
		repository.setPortNo(faker.number().numberBetween(1024, 65535));
		repository.setDbName(faker.company().name());
		return repository;
	}

}
