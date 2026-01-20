package com.cognizant.banking.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
public class CustomerTest {
	
	private Customer customer;
	private FullName fullName;
	@BeforeEach
	public void setUp() {
		customer = new Customer();
		fullName = new FullName();
		
	}
	
	@Test
	public void testCustomerNotNull() {
		assertNotNull(customer);
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/customer.csv", numLinesToSkip = 1)
	public void testGettersAndSetters(long accountNo,String firstName,String middleName,String lastName,
			String email, String password,long contactNo) {
		
		fullName.setFirstName(firstName);
		fullName.setMiddleName(middleName);
		fullName.setLastName(lastName);
		customer.setAccountNo(accountNo);
		customer.setFullName(fullName);		
		customer.setEmail(email);
		customer.setContactNo(contactNo);
		customer.setPassword(password);
		assertAll(
				() -> assertEquals(accountNo, customer.getAccountNo()),
				() -> assertEquals(firstName, customer.getFullName().getFirstName()),
				() -> assertEquals(middleName, customer.getFullName().getMiddleName()),
				() -> assertEquals(lastName, customer.getFullName().getLastName()),
				() -> assertEquals(email, customer.getEmail()),
				() -> assertEquals(contactNo, customer.getContactNo()),
				() -> assertEquals(password, customer.getPassword())
				);	
		
	}
	
	@AfterEach
	public void tearDown() {
		customer = null;
	}

}
