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
@Table(name = "patient")
public class Patient extends Person implements Serializable {
	@Column(name = "ailment", length = 100, nullable = false)
	private String ailment;	
	@Column(name = "occupation", length = 100, nullable = true)
	private String occupation;

	

}
