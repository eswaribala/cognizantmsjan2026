package com.cognizant.hospitalmgmt.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cognizant.hospitalmgmt.dtos.AddressDTO;
import com.cognizant.hospitalmgmt.dtos.AddressResponse;
import com.cognizant.hospitalmgmt.models.Address;



@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface AddressMapper {
	
	//dto to entity and entity to dto methods can be defined here
	Address dtotoentity(AddressDTO addressDTO);
    AddressResponse entitytodto(Address address);
    List<AddressResponse> entitytodto(List<Address> addresses);
}
