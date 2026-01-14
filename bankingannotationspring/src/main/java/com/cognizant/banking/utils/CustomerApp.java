package com.cognizant.banking.utils;
import java.util.logging.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cognizant.banking.models.Address;
import com.cognizant.banking.models.CompanyAddress;
import com.cognizant.banking.models.Corporate;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;
import com.cognizant.banking.models.HomeAddress;
import com.cognizant.banking.models.Individual;
import com.github.javafaker.Faker;



public class CustomerApp {

	public static void main(String[] args) {
		
		Faker faker=new Faker();		
		Logger logger=Logger.getLogger("CustomerApp");
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("banking-app.xml");
		//IOC
		FullName fullName1=context.getBean("fullName",FullName.class);
		//DI
		fullName1.setFirstName(faker.name().firstName());
		fullName1.setMiddleName(faker.name().nameWithMiddle());
		fullName1.setLastName(faker.name().lastName());
		logger.info("Full Name 1: "+fullName1);
		HomeAddress address1=context.getBean("homeAddress",HomeAddress.class);
		//DI
		address1.setDoorNo(faker.address().buildingNumber().toString());
		address1.setStreetName(faker.address().streetName());
		address1.setCity(faker.address().city());
		address1.setPinCode(faker.number().numberBetween(100000, 999999));
		logger.info("Address 1: "+address1);
		CompanyAddress address2=context.getBean("companyAddress",CompanyAddress.class);
		//DI
		
		  address2.setDoorNo(faker.address().buildingNumber().toString());
		  address2.setStreetName(faker.address().streetName());
		  address2.setCity(faker.address().city());
		  address2.setPinCode(faker.number().numberBetween(100000, 999999));
		  logger.info("Address 2: "+address2);
		 
		Customer customer1=(Customer) context.getBean("customer");
		//DI
		customer1.setAccountNo(faker.number().numberBetween(10000000, 99999999));
		customer1.setContactNo(faker.number().numberBetween(99990000, 99999999));
		customer1.setEmail(faker.internet().emailAddress());
		//customer1.setAddress(address1);
		customer1.setPassword(faker.internet().password(8, 16));
		logger.info("Customer 1: "+customer1);
		
	}

}
