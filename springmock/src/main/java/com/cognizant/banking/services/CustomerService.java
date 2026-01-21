package com.cognizant.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.banking.models.Customer;
import com.cognizant.banking.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}	
	
	public Customer getCustomerById(long accountNo) {
		return customerRepository.getCustomerById(accountNo);
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.addCustomer(customer);
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}
	
	public boolean deleteCustomer(long accountNo) {
		return customerRepository.deleteCustomer(accountNo);
	}
}
