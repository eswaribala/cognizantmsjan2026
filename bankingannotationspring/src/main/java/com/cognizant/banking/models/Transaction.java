package com.cognizant.banking.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Transaction {
	protected String senderName;
	protected String receiverName;
	protected long amount;
	protected LocalDate transactionDate;

}
