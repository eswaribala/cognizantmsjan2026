package com.cognizant.hospitalmgmt.models;
import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.cognizant.hospitalmgmt.facades.AdharCardId;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
	@Id
	@Column(name = "adhar_card_no", nullable = false, length = 12)
	@AdharCardId
	private String adharCardNo;
	@Embedded
	private FullName fullName;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false,length = 10)
	private Gender gender;
	@Column(name = "date_of_birth", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	@Column(name = "contact_number")
	private long contactNumber;
	@Column(name = "email", length = 150, unique = true,nullable = true)
	private String email;	
 
}
