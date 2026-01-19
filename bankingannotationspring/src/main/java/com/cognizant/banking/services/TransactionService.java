package com.cognizant.banking.services;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.banking.models.DirectDebitTransaction;
import com.cognizant.banking.models.ExternalDebitTransaction;
import com.cognizant.banking.models.Transaction;
import com.github.javafaker.Faker;

import lombok.Data;

@Service
@Data
public class TransactionService {
	
	private final Transaction directDebitTransaction;
	private final Transaction externalDebitTransaction;
	private Faker faker;
	
	
	public TransactionService(@Qualifier("directDebitTransaction")Transaction directDebitTransaction, 
			@Qualifier("externalDebitTransaction")Transaction externalDebitTransaction) {
		this.directDebitTransaction = directDebitTransaction;
		this.externalDebitTransaction = externalDebitTransaction;
		faker = new Faker();
	}
	
	public Transaction processDirectDebit() {
		DirectDebitTransaction directDebitTransaction=
				(DirectDebitTransaction) this.directDebitTransaction;
			
		directDebitTransaction.setSenderName(faker.name().fullName());
		directDebitTransaction.setReceiverName(faker.name().fullName());
		directDebitTransaction.setTransactionDate(faker.date().birthday().
				toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		directDebitTransaction.setAmount(faker.number()
				.numberBetween(10000, 100000));	
		directDebitTransaction.setPaymentDate(faker.date().birthday().
				toInstant().atZone(ZoneId.systemDefault()).toLocalDate());		
		
		return directDebitTransaction;
	}
	
	public Transaction processExternalDebit() {
		ExternalDebitTransaction externalDebitTransaction=
				(ExternalDebitTransaction) this.externalDebitTransaction;
		externalDebitTransaction.setSenderName(faker.name().fullName());
		externalDebitTransaction.setReceiverName(faker.name().fullName());
		externalDebitTransaction.setTransactionDate(faker.date().birthday().
				toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		externalDebitTransaction.setAmount(faker.number()
				.numberBetween(10000, 100000));
		externalDebitTransaction.setBranchAddress(faker.address().fullAddress());
		externalDebitTransaction.setBranchCode(faker.number().digits(5).toString());
		externalDebitTransaction.setBranchPostalCode(faker.address().zipCode());
		externalDebitTransaction.setBranchName(faker.company().name());
		
		return externalDebitTransaction;
	}

}
