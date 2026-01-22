package com.cognizant.hospitalmgmt.models;

import java.util.EnumSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

public class AdharCardIdGenerator implements BeforeExecutionGenerator {

	@Override
	public EnumSet<EventType> getEventTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
			EventType eventType) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
