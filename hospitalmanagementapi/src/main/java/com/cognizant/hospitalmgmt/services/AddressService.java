package com.cognizant.hospitalmgmt.services;

import java.util.List;

import com.cognizant.hospitalmgmt.models.Address;

public interface AddressService {
	
	Address addAddress(String adharCardNo, Address address);
	List<Address> getAllAddresses(String adharCardNo);
	Address getAddressById(String adharCardNo, Long addressId);
	Address updateAddress(String adharCardNo, Long addressId, Address address);
	boolean deleteAddress(String adharCardNo, Long addressId);

}
