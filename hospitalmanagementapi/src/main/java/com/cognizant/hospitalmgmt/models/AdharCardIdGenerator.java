package com.cognizant.hospitalmgmt.models;

import java.util.EnumSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import com.github.javafaker.Faker;

public class AdharCardIdGenerator implements BeforeExecutionGenerator {

	@Override
	public EnumSet<EventType> getEventTypes() {
		// TODO Auto-generated method stub
		return EnumSet.of(EventType.INSERT);
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
			EventType eventType) {
		Faker faker = new Faker();
		// TODO Auto-generated method stub
		if (currentValue != null) {
			return currentValue;
		}else {
			return faker.number().digits(12);
		}
	}
	

}
