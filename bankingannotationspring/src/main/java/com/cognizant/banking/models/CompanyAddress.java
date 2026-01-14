package com.cognizant.banking.models;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("companyAddress")
@ToString(callSuper = true)
public class CompanyAddress extends Address {

}
