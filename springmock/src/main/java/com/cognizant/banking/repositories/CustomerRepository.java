package com.cognizant.banking.repositories;

import java.util.List;

import com.cognizant.banking.models.Customer;

public interface CustomerRepository {
	
	Customer addCustomer(Customer customer);
	Customer getCustomerById(long accountNo);
	List<Customer> getAllCustomers();
	Customer updateCustomer(Customer customer);
	boolean deleteCustomer(long accountNo);

}
