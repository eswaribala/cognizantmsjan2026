package com.cognizant.banking.utils;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cognizant.banking.configurations.TransactionConfigurer;
import com.cognizant.banking.services.TransactionService;

public class TransactionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//zero xml configuration
		Logger logger = Logger.getLogger("TransactionApp");
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(TransactionConfigurer.class);
		
		TransactionService transactionService = context.getBean(TransactionService.class);
		logger.info("Direct Debit Transaction: " + transactionService.processDirectDebit());
		logger.info("External Debit Transaction: " + transactionService.processExternalDebit());
		

	}

}
