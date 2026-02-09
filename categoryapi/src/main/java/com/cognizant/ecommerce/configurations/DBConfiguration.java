package com.cognizant.ecommerce.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DBConfiguration {
	@Autowired
	private VaultConfiguration vaultConfiguration;
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(vaultConfiguration.getUri());
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		 return new MongoTemplate(mongoClient(),vaultConfiguration.getDatabaseName());

	}
	
	

}
