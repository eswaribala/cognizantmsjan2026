package com.cognizant.banking.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class RestConfigurer {
	
	@Bean
	public RestClient restClient() {
		return RestClient.create();
	}

}
