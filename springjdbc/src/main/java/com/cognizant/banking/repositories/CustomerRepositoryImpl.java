package com.cognizant.banking.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.banking.models.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    @Value("${addCustomer}")
    private String addCustomerQuery;
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int rows=jdbcTemplate.update(addCustomerQuery, 
				customer.getAccountNo(), customer.getFullName().getFirstName(),
				customer.getFullName().getMiddleName(),
				customer.getFullName().getLastName(), 
				customer.getEmail(), customer.getPassword(),customer.getContactNo());
		
		return rows>0;
	}

	@Override
	public Customer getCustomerById(long accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(long accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
