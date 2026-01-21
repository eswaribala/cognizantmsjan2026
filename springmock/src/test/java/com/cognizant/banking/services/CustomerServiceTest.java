package com.cognizant.banking.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;
import com.cognizant.banking.repositories.CustomerRepository;
import com.cognizant.banking.utils.CustomerApp;
import com.github.javafaker.Faker;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
	private CustomerRepository customerRepository;
    @InjectMocks
	private CustomerService customerService;   
    private static Customer customer;    
    private static FullName fullName;
    private static Faker faker;
    @BeforeAll
    public static void setup() {
		faker = new Faker();
		customer = new Customer();
		fullName = new FullName();
	}
    @Test
    public void addCustomerMockTest() {
    	customer.setAccountNo(faker.number().numberBetween(1000000000L, 9999999999L));
    	customer.setFullName(fullName);
        customer.getFullName().setFirstName(faker.name().firstName());
        customer.getFullName().setMiddleName(faker.name().nameWithMiddle());
        customer.getFullName().setLastName(faker.name().lastName());
        customer.setEmail(faker.internet().emailAddress());
        customer.setContactNo(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
        customer.setPassword(faker.internet().password(8, 10, true, true, true));
        Mockito.when(customerRepository.addCustomer(customer)).thenReturn(customer);        
        Customer result =customerService.addCustomer(customer);
        assertEquals(customer, result);
        assertEquals(result.getAccountNo(), customer.getAccountNo());
        
    	
    }
    @Test
    public void getAllCustomersMockTest() {
    	List<Customer> customers= CustomerApp.getAllCustomers();
    	Mockito.when(customerRepository.getAllCustomers()).thenReturn(customers);
    	List<Customer> result=customerService.getAllCustomers();
    	assertEquals(customers, result);
    	assertEquals(5, result.size());
    	assertEquals(customers.get(0).getAccountNo(), result.get(0).getAccountNo());
    }
    @Test
    public void deleteCustomerMockTest() {
		long accountNo=faker.number().numberBetween(1000000000L, 9999999999L);
		Mockito.when(customerRepository.deleteCustomer(accountNo)).thenReturn(true);
		boolean result=customerService.deleteCustomer(accountNo);
		assertTrue(result);
	}
    
}
