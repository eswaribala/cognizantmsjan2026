package com.cognizant.banking.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
	protected long accountNo;
	@Autowired
	
	protected FullName fullName;
	@Autowired
	@Qualifier("homeAddress")
	protected Address address;
	protected long contactNo;
	protected String email;
	protected String password;	

}
