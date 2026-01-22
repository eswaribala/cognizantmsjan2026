package com.cognizant.hospitalmgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
