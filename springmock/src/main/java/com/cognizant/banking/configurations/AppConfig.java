package com.cognizant.banking.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

@Configuration
@ComponentScan(basePackages = "com.cognizant.banking")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
@Data
public class AppConfig {
	@Value("${url}")
	private String url;
	@Value("${mysqlusername}")
	private String userName;
	@Value("${mysqlpassword}")
	private String password;
	@Value("${driver-class-name}")
	private String driverClassName;
	
	@Bean
	public HikariDataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setMaximumPoolSize(10);
		return dataSource;	
	
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(HikariDataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
