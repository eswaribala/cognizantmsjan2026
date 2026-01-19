package com.cognizant.banking.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cognizant.banking.models.DirectDebitTransaction;
import com.cognizant.banking.models.Transaction;

@Configuration
public class DirectDebitConfigurer {
	
	@Bean(name = "directDebitTransaction")
	public Transaction getDirectDebitTransaction() {
		return new DirectDebitTransaction();
	}

}
