package com.cognizant.banking.models;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.annotation.PreDestroy;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Customer implements BeanNameAware, 
BeanFactoryAware, ApplicationContextAware, 
InitializingBean, DisposableBean {
	Logger logger=LoggerFactory.getLogger(Customer.class);
	protected long accountNo;
		
	protected FullName fullName;
		
	protected Address address;
	protected long contactNo;
	protected String email;
	protected String password;
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Customer Bean is destroyed");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Customer Bean is initialized");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Application Context is set in Customer Bean"
		+applicationContext.getApplicationName());
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Bean Factory is set in Customer Bean"
		+beanFactory.getClass().getName());
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		logger.info("Bean Name is set in Customer Bean: "+name);
		
	}	
	
	public void customInit() {
		logger.info("Custom Init method called for Customer Bean");
	}
	public void customDestroy() {
		logger.info("Custom Destroy method called for Customer Bean");
	}
	@PreDestroy
	public void preDestroy() {
		logger.info("Pre Destroy method called for Customer Bean");
	}

}
