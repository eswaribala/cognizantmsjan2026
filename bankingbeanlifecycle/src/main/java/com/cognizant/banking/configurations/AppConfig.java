package com.cognizant.banking.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cognizant.banking.models.Address;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;
import com.github.javafaker.Faker;

@Configuration
@ComponentScan(basePackages = "com.cognizant.banking")
public class AppConfig {
	@Bean
	public CustomerBeanPostProcessor customerBeanPostProcessor() {
		return new CustomerBeanPostProcessor();
	}
	
	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public Customer customer() {
		Faker faker = new Faker();
		Customer customer = new Customer();
		customer.setAccountNo(faker.number().numberBetween(10000, 100000000));
		customer.setContactNo(faker.number().numberBetween(6000000000L, 9999999999L));
		customer.setEmail(faker.internet().emailAddress());
		customer.setPassword(faker.internet().password());
		FullName fullName = new FullName();
		fullName.setFirstName(faker.name().firstName());
		fullName.setLastName(faker.name().lastName());
		customer.setFullName(fullName);
	    Address address = new Address();
	    address.setStreetName(faker.address().streetAddress());
	    address.setCity(faker.address().city());
	    address.setDoorNo(faker.address().buildingNumber());
	    address.setPinCode(faker.number().numberBetween(100000, 999999));
	    customer.setAddress(address);
	    return customer;
		
	}

}
