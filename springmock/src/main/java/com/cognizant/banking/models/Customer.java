package com.cognizant.banking.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Component
@Scope("prototype")
public class Customer {
	Logger logger=LoggerFactory.getLogger(Customer.class);
	protected long accountNo;
	@Autowired	
	protected FullName fullName;	
	protected long contactNo;
	protected String email;
	protected String password;
	

}
