package com.cognizant.hospitalmgmt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cognizant.hospitalmgmt.dtos.AddressDTO;
import com.cognizant.hospitalmgmt.models.Address;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface AddressMapper {
	@Mapping(target = "personDTO", source = "person")
	//dto to entity and entity to dto methods can be defined here
	Address dtotoentity(AddressDTO addressDTO);

}
