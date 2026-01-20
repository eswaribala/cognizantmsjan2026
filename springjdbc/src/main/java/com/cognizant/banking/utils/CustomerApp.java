package com.cognizant.banking.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.banking.configurations.AppConfig;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.repositories.CustomerRepositoryImpl;
import com.cognizant.banking.services.CustomerService;
import com.github.javafaker.Faker;

public class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Faker faker = new Faker();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerRepositoryImpl customerRepository = context.getBean(CustomerRepositoryImpl.class);
		Customer customer = context.getBean(Customer.class);		
		customer.setAccountNo(faker.number().numberBetween(1000000000L, 9999999999L));
		customer.getFullName().setFirstName(faker.name().firstName());
		customer.getFullName().setMiddleName(faker.name().nameWithMiddle());
		customer.getFullName().setLastName(faker.name().lastName());
		customer.setEmail(faker.internet().emailAddress());
		customer.setContactNo(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
		customer.setPassword(faker.internet().password(8, 10, true, true, true));
		/*
		 * boolean isAdded = customerRepository.addCustomer(customer); if(isAdded) {
		 * System.out.println("Customer added successfully!"); } else {
		 * System.out.println("Failed to add customer."); }
		 */
	  List<Long> accountNos=customerRepository.getAllCustomers()
			  .stream().map(c->c.getAccountNo()).toList();
	  long randomNo= accountNos.get(new Random().nextInt(accountNos.size()));
	  Customer fetchedCustomer=customerRepository.getCustomerById(randomNo);
	  System.out.println("Fetched Customer Details:");
	  System.out.println(fetchedCustomer);
		
        context.close();
		
	}
	
	public static List<Customer> getAllCustomers(){
		List<Customer> customers=new ArrayList<>();
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
			customers.add(customer);
		}
		return customers;
	}
	
	
	

}
