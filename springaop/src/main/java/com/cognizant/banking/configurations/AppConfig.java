package com.cognizant.banking.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.cognizant.banking")
@EnableAspectJAutoProxy
public class AppConfig {

}
