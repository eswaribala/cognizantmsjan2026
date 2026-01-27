package com.cognizant.hospitalmgmt.mappers;

import org.mapstruct.Mapper;

import com.cognizant.hospitalmgmt.dtos.FullNameResponse;
import com.cognizant.hospitalmgmt.models.FullName;

@Mapper(componentModel = "spring")
public interface FullNameMapper {

	FullNameResponse toDTOs(FullName fullName);
}
