package com.cognizant.ecommerce.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
@Data
@ConfigurationProperties
public class VaultConfiguration {
	
	private String mysqlusername;
	private String mysqlpassword;
	

}
