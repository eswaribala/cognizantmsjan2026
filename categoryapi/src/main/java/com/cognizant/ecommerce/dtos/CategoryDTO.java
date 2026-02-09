package com.cognizant.ecommerce.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO { 	
	
	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Name must be alphanumeric")
	private String categoryName;	
	
}
