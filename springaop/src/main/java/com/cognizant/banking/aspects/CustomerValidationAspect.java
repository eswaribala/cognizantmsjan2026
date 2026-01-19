package com.cognizant.banking.aspects;

import java.util.regex.Pattern;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.banking.models.Customer;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CustomerValidationAspect {
	Logger logger = LoggerFactory.getLogger(CustomerValidationAspect.class);
    final Pattern namePattern=Pattern.compile("^[a-zA-Z]{5,25}$");
    final Pattern emailPattern=Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
	final Pattern phonePattern=Pattern.compile("^[0-9]{10}$");
	
	private void validateCustomer(Customer customer) {
	    // Logic to validate customer details
		if(customer.getAccountNo() < 0 
				|| String.valueOf(customer.getAccountNo()).length()<10){
			
			throw new IllegalArgumentException("Invalid account number");
		}
		if(customer.getFullName().getFirstName()==null ||  
				!namePattern.matcher(customer.getFullName().getFirstName()).matches()) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(customer.getFullName().getLastName()==null ||
				!namePattern.matcher(customer.getFullName().getLastName()).matches()) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
	}

}
