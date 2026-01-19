package com.cognizant.banking.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cognizant.banking.models.ExternalDebitTransaction;
import com.cognizant.banking.models.Transaction;

@Configuration
public class ExternalDebitConfigurer {
	
	@Bean(name = "externalDebitTransaction")
	public Transaction getExternalDebitTransaction() {
		return new ExternalDebitTransaction();
	}

}
