package com.cognizant.hospitalmgmt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cognizant.hospitalmgmt.dtos.PersonResponse;
import com.cognizant.hospitalmgmt.models.Person;

@Mapper(componentModel = "spring", uses = {FullNameMapper.class})
public interface PersonMapper {
	//dto to entity and entity to dto methods can be defined here
	@Mapping(target = "fullNameResponse", source = "fullName")
	@Mapping(target = "contactNo", source = "contactNumber")
	@Mapping(target="dob", source="dateOfBirth")
	PersonResponse entityToDto(Person person);

}
