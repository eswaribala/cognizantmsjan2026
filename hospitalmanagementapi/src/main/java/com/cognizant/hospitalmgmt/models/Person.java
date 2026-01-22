package com.cognizant.hospitalmgmt.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public abstract class Person {
	@Id
	@Column(name = "adhar_card_no", nullable = false, length = 12)
	private String adharCardNo;
	private FullName fullName;
	private Gender gender;
 
}
