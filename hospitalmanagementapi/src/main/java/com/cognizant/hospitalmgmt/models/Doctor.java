package com.cognizant.hospitalmgmt.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "doctor")
public class Doctor extends Person implements Serializable {
	@Column(name = "license_number", length = 50, nullable = false, unique = true)
	private String licenseNumber;
	@Column(name = "specialization", length = 100, nullable = false)
	private String specialization;	
	@Column(name = "qualification", length = 100, nullable = false)
	private String qualification;

}
