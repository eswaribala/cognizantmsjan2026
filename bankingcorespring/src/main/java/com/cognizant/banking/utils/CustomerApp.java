package com.cognizant.banking.utils;
import java.util.logging.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cognizant.banking.models.Address;
import com.cognizant.banking.models.Corporate;
import com.cognizant.banking.models.Customer;
import com.cognizant.banking.models.FullName;
import com.cognizant.banking.models.Individual;



public class CustomerApp {

	public static void main(String[] args) {
		
		Logger logger=Logger.getLogger("CustomerApp");
		
		// TODO Auto-generated method stub
        //IOC
		//Step1
		Resource resource=new ClassPathResource("banking-app.xml");
		//step2
		DefaultListableBeanFactory defaultListableBeanFactory=
				new DefaultListableBeanFactory();
		//Step3
		XmlBeanDefinitionReader xmlBeanDefinitionReader=
				new XmlBeanDefinitionReader(defaultListableBeanFactory);
		//Step4
		xmlBeanDefinitionReader.loadBeanDefinitions(resource);
		
		// step5
		//Actual IOC 
		FullName fullName=(FullName) defaultListableBeanFactory.getBean("fullName");
		
		logger.info("FullName="+fullName);
		
		Address address1=(Address) defaultListableBeanFactory.getBean("address1");
		logger.info("Address1="+address1);
		Address address2=(Address) defaultListableBeanFactory.getBean("address2");
		logger.info("Address2="+address2);
		
		Customer customer1=(Customer) defaultListableBeanFactory.getBean("customer");
		logger.info("Customer="+customer1);
		
		Customer customer2=(Customer) defaultListableBeanFactory.getBean("customer");
		logger.info("Customer2="+customer2);
		
		customer2.setAccountNo(9876543210L);
		logger.info("After modification Customer1="+customer1);
		logger.info("After modification  Customer2="+customer2);
		//Individual individual=(Individual) defaultListableBeanFactory.getBean("individual");
		//logger.info("Individual="+individual);
		//Corporate corporate=(Corporate) defaultListableBeanFactory.getBean("corporate");
		//logger.info("Corporate="+corporate);
		
		
	}

}
