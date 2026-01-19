package com.cognizant.banking.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.banking.configurations.AppConfig;
import com.cognizant.banking.models.Customer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Logger logger=LoggerFactory.getLogger(CustomerApp.class);
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Customer customer = context.getBean(Customer.class);
	    logger.info("Customer Details: " + customer);
		context.close();
		
	}

}
