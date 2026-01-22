package com.cognizant.hospitalmgmt.facades;

import java.lang.annotation.Target;

import org.hibernate.annotations.IdGeneratorType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.cognizant.hospitalmgmt.models.AdharCardIdGenerator;

@IdGeneratorType(AdharCardIdGenerator.class)
@Target({ ElementType.FIELD, ElementType.METHOD,
		ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AdharCardId {

}
