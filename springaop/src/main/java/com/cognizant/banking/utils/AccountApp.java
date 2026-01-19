package com.cognizant.banking.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.banking.configurations.AppConfig;
import com.cognizant.banking.models.Account;
import com.github.javafaker.Faker;

public class AccountApp {

	public static void main(String[] args) {
		Faker faker = new Faker();
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);
        Account savingsAccount = 
				(Account) context.getBean("savingsAccount");
        savingsAccount.setAccountNumber(faker.number().numberBetween(100000, 100000000));
		savingsAccount.setOpeningDate(faker.date().birthday().toInstant()
				.atZone(java.time.ZoneId.systemDefault())
				.toLocalDate());
		savingsAccount.setRunningTotal(faker.number().numberBetween(1000, 100000));
		context.close();
		
	}

}
