package com.cognizant.ecommerce.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DBConfiguration {
	@Autowired
	private VaultConfiguration vaultConfiguration;
	@Value("${url}")
	private String dbUrl;
	@Value("${driverClassName}")
	private String dirverClassName;	
	private DataSource dataSource;
	@Bean
	private DataSource getDataSource() {
		dataSource=DataSourceBuilder.create()
				.url(dbUrl)
				.username(vaultConfiguration.getMysqlusername())
				.password(vaultConfiguration.getMysqlpassword())
				.driverClassName(dirverClassName)
				.build();
		return dataSource;
	}
	
	

}
