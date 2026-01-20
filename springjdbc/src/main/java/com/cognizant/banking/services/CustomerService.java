package com.cognizant.banking.services;

import org.springframework.stereotype.Service;

import com.cognizant.banking.models.Customer;

@Service
public class CustomerService {
	
	
	public void addCustomer(Customer customer) {
	    // Logic to add customer to the database
	    System.out.println("Customer added: "+customer);
	}

}
