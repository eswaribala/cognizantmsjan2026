package com.cognizant.ecommerce.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ecommerce.dtos.GenericResponse;
import com.cognizant.ecommerce.dtos.CategoryDTO;
import com.cognizant.ecommerce.exceptions.CategoryNullException;
import com.cognizant.ecommerce.mappers.CategoryMapper;
import com.cognizant.ecommerce.models.Category;
import com.cognizant.ecommerce.services.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Category")

public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryMapper categoryMapper;
	@CrossOrigin(origins = "*")
	
	@PostMapping("/v1.0")
	public ResponseEntity<GenericResponse> addCategory(@RequestBody 
			CategoryDTO categoryDTO) throws CategoryNullException {
		Category category=categoryMapper.dtotoentity(categoryDTO);
		Category savedCategory=categoryService.addCategory(category);
		if(savedCategory==null) {
			ResponseEntity.status(400)
			.body(new GenericResponse("Category cannot be null"));
		}
		CategoryDTO savedCategoryDTO=categoryMapper.entitytodto(savedCategory);		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new GenericResponse(savedCategoryDTO));	
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/v1.0")
	
	public ResponseEntity<GenericResponse> getAllCategories() {
		List<CategoryDTO> categoryDTOs=categoryMapper
				.entitytolistdto(categoryService.getAllCategories());		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericResponse(categoryDTOs));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/v1.0/{id}")
	public ResponseEntity<GenericResponse> 
	getCategoryById(@PathParam("id") int id) {
		Category category=categoryService.getCategoryById(id);		
		CategoryDTO categoryDTO=categoryMapper.entitytodto(category);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericResponse(categoryDTO));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/v1.0/byName")
	public ResponseEntity<GenericResponse> 
	   getCategoryByName(@RequestParam String name) {
		Category category=categoryService.getCategoryByName(name);		
		CategoryDTO CategoryDTO=categoryMapper.entitytodto(category);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericResponse(CategoryDTO));
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/v1.0/{id}")
	public ResponseEntity<GenericResponse> 
	   updateCategory(@PathParam("id") long id,@RequestParam String name) {
		Category category=categoryService.updateCategory(id, name);	
		CategoryDTO categoryDTO=categoryMapper.entitytodto(category);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericResponse(categoryDTO));
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/v1.0/{id}")
	public ResponseEntity<GenericResponse<String>> deleteCategoryById(@PathParam("id") int id) {
		boolean status=categoryService.deleteCategory(id);
		if(!status) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new GenericResponse<>("Category not found"));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GenericResponse<>("Category deleted successfully"));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/v1.0/publish")
	public CompletableFuture<ResponseEntity<String>> publishCategories() throws JsonProcessingException  {
		return categoryService.publishCategoriesToKafka()
                .thenApply(result->ResponseEntity.status(HttpStatus.OK)
                        .body(result.getRecordMetadata().topic()+","+result.getRecordMetadata().partition()+","+result.getRecordMetadata().offset()))
                .exceptionally(ex-> {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
                });

			
		  
		  

	}

}
