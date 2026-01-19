package com.cognizant.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ExternalDebitTransaction extends Transaction {
	private String branchName;
	private String branchAddress;
	private String branchPostalCode;
	private String branchCode;

}
