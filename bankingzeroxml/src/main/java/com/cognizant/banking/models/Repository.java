package com.cognizant.banking.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public abstract class Repository {
	protected String ipAddress;
	protected int portNo;
	protected String dbName;

}
 