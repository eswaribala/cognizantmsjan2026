package com.cognizant.banking.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.banking.configurations.AppConfig;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;
import com.github.javafaker.Faker;

public class PerformanceMeasuringApp {

	public static void main(String[] args) {
		Faker faker=new Faker();
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
	   Customer customer=context.getBean(Customer.class);
	   FullName fullName=context.getBean(FullName.class);
	   fullName.setFirstName(faker.name().firstName());
	   fullName.setMiddleName(faker.name().nameWithMiddle());
	   fullName.setLastName(faker.name().lastName());
	   customer.setFullName(fullName);
	   customer.setAccountNo(faker.number().numberBetween(1000000000L, 9999999999L));		
		customer.setEmail(faker.internet().emailAddress());
		customer.setContactNo(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
		customer.setPassword(faker.internet().password(8, 16, true, true, true));
	   
	   

	}

}
