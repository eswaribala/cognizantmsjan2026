package com.cognizant.hospitalmgmt.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cognizant.hospitalmgmt.dtos.PatientResponse;
import com.cognizant.hospitalmgmt.models.Patient;

@Mapper(componentModel = "spring", uses = {FullNameMapper.class})
public interface PatientMapper {
	@Mapping(source = "fullName", target = "fullNameResponse")
    @Mapping(source = "dateOfBirth", target = "dob")
    @Mapping(source = "contactNumber", target = "contactNo")
		PatientResponse toDTOs(Patient patient);
		List<PatientResponse> toDTOs(List<Patient> patients);
		
		//Patient toObject(PatientDTO patientDTO);

}
