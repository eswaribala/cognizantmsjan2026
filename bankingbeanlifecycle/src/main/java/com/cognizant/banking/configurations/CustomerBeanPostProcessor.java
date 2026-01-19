package com.cognizant.banking.configurations;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.cognizant.banking.models.Customer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    Logger logger=LoggerFactory.getLogger(CustomerBeanPostProcessor.class);
	@Override
	public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(bean instanceof Customer) {
			logger.info("Customer Bean is about to be initialized: "+beanName);
		}
		return bean;
	}

	@Override
	public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(bean instanceof Customer) {
			logger.info("Customer Bean has been initialized: "+beanName);
		}
		return bean;
	}

	

}
