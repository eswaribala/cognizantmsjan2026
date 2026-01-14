package com.cognizant.banking.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	protected long accountNo;
	protected FullName fullName;
	protected List<Address> addresses;
	protected long contactNo;
	protected String email;
	protected String password;	

}
