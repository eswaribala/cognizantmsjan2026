package com.cognizant.ecommerce.configurations;

import org.springdoc.core.providers.RepositoryRestResourceProvider;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class SwaggerConfiguration implements RepositoryRestConfigurer {

	 @Override
	    public void configureRepositoryRestConfiguration
	    (RepositoryRestConfiguration config, CorsRegistry cors) {
	          config.setExposeRepositoryMethodsByDefault(false);
	    }
}
