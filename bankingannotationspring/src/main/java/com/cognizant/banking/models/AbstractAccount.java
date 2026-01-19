package com.cognizant.banking.models;

import java.time.LocalDate;


import com.cognizant.banking.facades.Account;

import lombok.Data;
@Data
public abstract class AbstractAccount implements Account {
	protected long runningTotal;
	protected LocalDate openingDate;

}
