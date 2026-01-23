package com.cognizant.hospitalmgmt.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName {
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only alphabetic characters")
	private String firstName;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name must contain only alphabetic characters")
	private String lastName;
}
