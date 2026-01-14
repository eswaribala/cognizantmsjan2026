package com.cognizant.banking.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Scope("prototype")

public class Address {
	private String doorNo;
	private String streetName;
	private String city;
	private long pinCode;

}
