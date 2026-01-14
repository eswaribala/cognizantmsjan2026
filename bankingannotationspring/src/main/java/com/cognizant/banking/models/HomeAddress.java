package com.cognizant.banking.models;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("homeAddress")
@ToString(callSuper = true)
public class HomeAddress extends Address {

}
