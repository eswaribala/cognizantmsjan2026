package com.cognizant.hospitalmgmt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByPersonAdharCardNo(String adharCardNo);
	//method name matters, spring jpa will create query based on method name
	 Optional<Address> findByIdAndPersonAdharCardNo(Long id, String adharCardNo);
	//method name matters, spring jpa will create query based on method name
	 boolean existsByIdAndPersonAdharCardNo(Long id, String adharCardNo);
}
