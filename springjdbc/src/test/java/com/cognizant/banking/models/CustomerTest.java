package com.cognizant.banking.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.cognizant.banking.utils.CustomerApp;
import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
public class CustomerTest {
	
	private Customer customer;
	private FullName fullName;
	private SavingsAccount savingsAccount;
	@BeforeEach
	public void setUp() {
		customer = new Customer();
		fullName = new FullName();
		
	}
	@Nested
	class FullNameTest{
		@ParameterizedTest
		@ValueSource(strings = {"John","A.","Doe"})
		public void testFullName(String firstName, String middleName, String lastName) {
			fullName.setFirstName(firstName);
			fullName.setMiddleName(middleName);
			fullName.setLastName(lastName);
			assertAll(
					() -> assertTrue(firstName.equals(fullName.getFirstName())),
					() -> assertTrue(middleName.equals(fullName.getMiddleName())),
					() -> assertTrue(lastName.equals(fullName.getLastName()))
					);
		}
		
	}
	@Nested
	class AccountNoTest{
		@Test
		public void testAccountNo() {
			List<Long> accountNos = CustomerApp.getAllCustomers()
					  .stream().map(c->c.getAccountNo()).toList();
			assertAll(
					() -> assertTrue(accountNos.stream().allMatch(no -> no >= 1000000000L 
					&& no <= 9999999999L)),
					() -> assertEquals(5, accountNos.size()),
					()-> assertFalse(accountNos.isEmpty())
					);
		 
		}
		
	}
	
	@Nested
	class EmailTest{
		@ParameterizedTest
		@MethodSource("provideCustomers")
		public void testEmail(Customer customer) {
			String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
			assertTrue(customer.getEmail().matches(emailRegex));
		}
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

	
	public static Stream<Arguments> provideCustomers() {
		List<Arguments> customerStream = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			Customer customer=new Customer();
			Faker faker = new Faker();
			customer.setAccountNo(faker.number().numberBetween(1000000000L, 9999999999L));
			customer.getFullName().setFirstName(faker.name().firstName());
			customer.getFullName().setMiddleName(faker.name().nameWithMiddle());
			customer.getFullName().setLastName(faker.name().lastName());
			customer.setEmail(faker.internet().emailAddress());
			customer.setContactNo(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
			customer.setPassword(faker.internet().password(8, 10, true, true, true));
			customerStream.add(Arguments.of(customer));
		}
		return customerStream.stream();
	}
}
