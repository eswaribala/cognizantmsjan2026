package com.cognizant.banking.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = "com.cognizant.banking") 
@Import({DirectDebitConfigurer.class, ExternalDebitConfigurer.class})
public class TransactionConfigurer {

}
