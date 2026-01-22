package com.cognizant.hospitalmgmt.models;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "house_number", nullable = false, length = 10)
	private String houseNumber;
	@Column(name = "street_name", nullable = false, length = 100)
	private String streetName;
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	@Column(name = "zip_code", nullable = false, length = 10)
	private String zipCode;
	@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch =FetchType.LAZY )
	@JoinColumn(foreignKey = @ForeignKey(name = "adharCardNo"),name = "person_adhar_card_no")
	private Person person;

}
