package com.cognizant.banking.repositories;

import java.util.List;

import com.cognizant.banking.models.Customer;

public interface CustomerRepository {
	
	boolean addCustomer(Customer customer);
	Customer getCustomerById(long accountNo);
	List<Customer> getAllCustomers();
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(long accountNo);

}
