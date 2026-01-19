package com.cognizant.banking.utils;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("UserApp");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("banking-app.xml");
		UserDataDao userDataDao = context.getBean(UserDataDao.class);
		userDataDao.getUserData().entrySet().stream()
		.map(entry->entry.getKey()+" : "+entry.getValue()).forEach(logger::info);
		

	}

}
