package com.cognizant.hospitalmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.hospitalmgmt.dtos.AddressDTO;
import com.cognizant.hospitalmgmt.dtos.AddressResponse;
import com.cognizant.hospitalmgmt.dtos.GenericMessage;
import com.cognizant.hospitalmgmt.mappers.AddressMapper;
import com.cognizant.hospitalmgmt.models.Address;
import com.cognizant.hospitalmgmt.services.AddressService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private AddressMapper addressMapper;
	@PostMapping("/v1.0/{adharCardNo}")
	public ResponseEntity<GenericMessage> addAddress(@RequestBody AddressDTO addressDTO,@PathParam("adharCardNo") String adharCardNo){
		//dto to entity
		Address address=addressMapper.dtotoentity(addressDTO);
		Address savedAddress=addressService.addAddress(adharCardNo,address);
		//entity to dto
		AddressResponse addressResponse=addressMapper.entitytodto(savedAddress);
		GenericMessage genericMessage=new GenericMessage("Address added successfully"+addressResponse,null);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(genericMessage);
	}
	
	@GetMapping("/v1.0")
	public ResponseEntity<GenericMessage> getAllAddresses(@RequestParam String adharCardNo){
		List<Address> addresses=addressService.getAllAddresses(adharCardNo);
		List<AddressResponse> addressResponse=addressMapper.entitytodto(addresses);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericMessage("Addresses fetched successfully"+addressResponse,null));
	}
	

}
