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
@Scope("prototype")
public class FullName {
	private String firstName;
	private String middleName;
	private String lastName;

}
