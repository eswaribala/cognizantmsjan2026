package com.cognizant.ecommerce.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.cognizant.ecommerce.exceptions.CategoryNotFoundException;
import com.cognizant.ecommerce.exceptions.CategoryNullException;
import com.cognizant.ecommerce.models.Category;
import com.cognizant.ecommerce.repositories.CategoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	@Value("${topicName}")
	private String topicName;

	@Override
	public Category addCategory(Category category) throws CategoryNullException {
		// TODO Auto-generated method stub
		if (category != null) {
			return categoryRepository.save(category);
		}else
			throw new CategoryNullException("Category cannot be null");
		
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id)
				.orElseThrow(()-> 
				new CategoryNotFoundException("Category not found"));
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryName(name)
				.stream()
				.findFirst()
				.orElseThrow(()-> 
				new CategoryNotFoundException("Category not found"));
	}

	@Override
	public Category updateCategory(long id, String name) {
		// TODO Auto-generated method stub
		Category category=getCategoryById(id);
		if(category!=null) {
			category.setCategoryName(name);
			return categoryRepository.save(category);
		}else {
			throw new CategoryNotFoundException("Category not found");
		}
		
		
	}

	@Override
	public boolean deleteCategory(long id) {
		// TODO Auto-generated method stub
		if(categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public CompletableFuture<SendResult<String, String>> publishCategoriesToKafka() throws JsonProcessingException {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();
		ObjectWriter ow = new ObjectMapper()
				.writer().withDefaultPrettyPrinter();
		String jsonData = ow.writeValueAsString(categories);
		
		return kafkaTemplate.send(topicName, jsonData);
	}

}
