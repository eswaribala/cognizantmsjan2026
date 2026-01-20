package com.cognizant.banking.models;

import java.time.LocalDate;


import lombok.Data;
@Data
public abstract class Account {
	protected long accountNumber;
	protected long runningTotal;
	protected LocalDate openingDate;

}
