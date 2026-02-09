package com.cognizant.ecommerce.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cognizant.ecommerce.dtos.CategoryDTO;

import com.cognizant.ecommerce.models.Category;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
	//dto to entity 
	Category dtotoentity(CategoryDTO categoryDTO);
	
	//entity to dto
	CategoryDTO entitytodto(Category category);
	//list of entity to list of dto
	List<CategoryDTO> entitytolistdto(List<Category> categories);
	

}
