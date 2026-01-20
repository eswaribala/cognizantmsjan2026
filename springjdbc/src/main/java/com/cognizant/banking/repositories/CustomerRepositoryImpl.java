package com.cognizant.banking.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.banking.configurations.AppConfig;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    @Value("${addCustomer}")
    private String addCustomerQuery;
    @Value("${selectAllCustomers}")
    private String selectAllCustomersQuery;
    @Value("${selectCustomerById}")
    private String selectCustomerByIdQuery;
    @Value("${updateCustomerContactNo}")
    private String updateCustomerQuery;
    @Value("${deleteCustomerById}")
    private String deleteCustomerQuery;
    @Autowired 
    ObjectProvider<Customer> customerProvider;
    @Autowired 
    ObjectProvider<FullName> fullNameProvider;
   
	
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
		return jdbcTemplate.queryForObject(selectCustomerByIdQuery, this::mapRowToCustomer, 
				accountNo);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(selectAllCustomersQuery, this::mapRowToCustomer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(updateCustomerQuery, customer.getContactNo(),
				customer.getAccountNo())>0;
	}

	@Override
	public boolean deleteCustomer(long accountNo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(deleteCustomerQuery, accountNo)>0;
	}
	
	
	private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = customerProvider.getObject(); 
	    FullName fullName = fullNameProvider.getObject();
		customer.setFullName(fullName);
		customer.setAccountNo(rs.getLong("account_no"));
		customer.getFullName().setFirstName(rs.getString("first_name"));
		customer.getFullName().setMiddleName(rs.getString("middle_name"));
		customer.getFullName().setLastName(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));
		customer.setPassword(rs.getString("password"));
		customer.setContactNo(rs.getLong("contact_no"));
		return customer;
		
	}

}
