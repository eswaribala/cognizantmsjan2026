package com.cognizant.hospitalmgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByPersonAdharCardNo(String adharCardNo);
	Address findByIds(String adharCardNo,long addressId);
	boolean existsByIdAndPersonAdharCardNo(Long addressId, String adharCardNo);
}
