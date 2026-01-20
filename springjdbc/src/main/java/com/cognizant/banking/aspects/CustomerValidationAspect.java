package com.cognizant.banking.aspects;

import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.banking.models.Customer;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CustomerValidationAspect {
	Logger logger = LoggerFactory.getLogger(CustomerValidationAspect.class);
    final Pattern namePattern=Pattern.compile("^[a-zA-Z]{5,25}$");
    final Pattern emailPattern=Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
	final Pattern passwordPattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
	@Before("execution(* com.cognizant.banking.services.CustomerService.addCustomer(..)) && args(customer)")
	public void addCustomerValidation(Customer customer) {
		logger.info("Start - addCustomerValidation");
	   // validateCustomer(customer);
	    logger.info("End - addCustomerValidation");
	}
	 @Around("execution(* com.cognizant.banking.services.CustomerService.addCustomer(..)) && args(customer)")
	    public Object validateAndProceed(ProceedingJoinPoint pjp, Customer customer) throws Throwable {
	        log.info("Start - addCustomerValidation");
	        try {
	            validateCustomer(customer);         // ✅ validate here
	            Object result = pjp.proceed();      // ✅ run service method
	            log.info("End - addCustomerValidation");
	            return result;
	        } catch (IllegalArgumentException ex) {
	            log.error("Validation failed: {}", ex.getMessage());
	            throw ex;
	        }
	    }

	@AfterThrowing(
			  pointcut = "execution(* com.cognizant.banking.aspects.*.*(..))",
			  throwing = "ex"
			)
			public void serviceException(Throwable ex) {
			  log.error("Service exception: {}", ex.getMessage(), ex);
			}
	public void addCustomerValidationException(Throwable ex) {
		logger.info("Exception in CustomerService method: "
				+ "Invalid customer details"+ex.getMessage());
	}
	
	private void validateCustomer(Customer customer) {
	    // Logic to validate customer details
		if(customer.getAccountNo() < 0 
				|| String.valueOf(customer.getAccountNo()).length()<10){
			
			throw new IllegalArgumentException("Invalid account number");
		}
		if(customer.getFullName().getFirstName()==null ||  
				!namePattern.matcher(customer.getFullName().getFirstName()).matches()) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(customer.getFullName().getLastName()==null ||
				!namePattern.matcher(customer.getFullName().getLastName()).matches()) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if(customer.getEmail()==null || 
				!emailPattern.matcher(customer.getEmail()).matches()) {
			throw new IllegalArgumentException("Invalid email");
		}
		
		if(customer.getContactNo()<0 || 
				String.valueOf(customer.getContactNo()).length()<10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(customer.getPassword()==null || 
				!passwordPattern.matcher(customer.getPassword()).matches()) {
			throw new IllegalArgumentException("Invalid password");
		}
	}

}
