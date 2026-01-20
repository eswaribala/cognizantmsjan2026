package com.cognizant.banking.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class CustomerTest {
	
	private Customer customer;
	private FullName fullName;
	private SavingsAccount savingsAccount;
	@BeforeEach
	public void setUp() {
		customer = new Customer();
		fullName = new FullName();
		
	}
	
	@Test
	@RepeatedTest(3)
	@DisplayName("Customer Object Not Null Test")
	@Order(2)
	@Tag("dev")
	public void testCustomerNotNull() {
		assertNotNull(customer);
	}
	@ParameterizedTest	
	@DisplayName("Customer Getters and Setters Test")
	@Order(1)
	@Tag("qa")
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
	
	@ParameterizedTest
	@ValueSource(longs = {1234567890L, 9876543210L, 5555555555L})
	@Tag("qa")
	public void TestGettersAndSettersNegative(long contactNo) {
		customer.setContactNo(contactNo);
		assertNotEquals(1111111111L, customer.getContactNo());
	}
	@Test
	@DisplayName("Savings Account Exception Test")
	@Order(3)
	@Tag("dev")
	public void testSavingsAccountExceptionNegative() {
		
		assertThrows(NullPointerException.class, ()->savingsAccount.getRoi());
	}
	@AfterEach
	public void tearDown() {
		customer = null;
	}

}
