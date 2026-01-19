package com.cognizant.banking.utils;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.banking.models.MySQLRepository;
import com.cognizant.banking.models.OracleRepository;
import com.cognizant.banking.models.Repository;
import com.cognizant.banking.services.DBService;

public class DBApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("DBApp");
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		context.register(MySQLRepository.class);
		context.register(OracleRepository.class);
		context.register(DBService.class);
		context.refresh();
		
		DBService dbService = context.getBean(DBService.class);
		logger.info("Repository Details: " + dbService.getRepositoryDetails());
		

	}

}
