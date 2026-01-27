package com.cognizant.hospitalmgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hospitalmgmt.exceptions.PersonNotFoundException;
import com.cognizant.hospitalmgmt.models.Address;
import com.cognizant.hospitalmgmt.models.Person;
import com.cognizant.hospitalmgmt.repositories.AddressRepository;
import com.cognizant.hospitalmgmt.repositories.PersonRepository;

@Service
public class AddressImpl implements AddressService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(String adharCardNo, Address address) {
		// TODO Auto-generated method stub
		Person person = personRepository.findById(adharCardNo)
				.orElseThrow(()->new PersonNotFoundException("Person not found with Adhar Card No: " + adharCardNo));
		address.setPerson(person);
		return addressRepository.save(address);		
	}

	@Override
	public List<Address> getAllAddresses(String adharCardNo) {
		// TODO Auto-generated method stub
		return addressRepository.findByPersonAdharCardNo(adharCardNo);
	}

	@Override
	public Address getAddressById(String adharCardNo, Long addressId) {
		// TODO Auto-generated method stub
		return addressRepository.findByIds(adharCardNo, addressId);
	}

	@Override
	public Address updateAddress(String adharCardNo, Long addressId, Address address) {
		// TODO Auto-generated method stub
		Person person = personRepository.findById(adharCardNo)
				.orElseThrow(()->new PersonNotFoundException
						("Person not found with Adhar Card No: " + adharCardNo));
	     Address existingAddress = 
				addressRepository.findByIds(adharCardNo, addressId);
		existingAddress.setStreetName(address.getStreetName());
		existingAddress.setCity(address.getCity());
		existingAddress.setState(address.getState());
		existingAddress.setZipCode(address.getZipCode());
		existingAddress.setHouseNumber(address.getHouseNumber());
		existingAddress.setPerson(person);
		return addressRepository.save(existingAddress);
		
	}

	@Override
	public boolean deleteAddress(String adharCardNo, Long addressId) {
		// TODO Auto-generated method stub
		return personRepository.existsById(adharCardNo) && 
				addressRepository.existsByIdAndPersonAdharCardNo(addressId, adharCardNo);
		
	}

}
