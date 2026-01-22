package com.cognizant.hospitalmgmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FullName {
	@Column(name = "first_name", nullable = false,length = 50)
	private String firstName;
	@Column(name = "last_name", nullable = false,length = 50)
	private String lastName;

}
