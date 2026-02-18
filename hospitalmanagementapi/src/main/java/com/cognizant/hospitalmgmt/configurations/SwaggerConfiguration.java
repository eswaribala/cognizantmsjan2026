package com.cognizant.hospitalmgmt.configurations;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;




@Configuration
public class SwaggerConfiguration implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		config.setExposeRepositoryMethodsByDefault(false);
	}

   
}