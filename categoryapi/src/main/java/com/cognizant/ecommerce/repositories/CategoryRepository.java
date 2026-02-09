package com.cognizant.ecommerce.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.ecommerce.models.Category;


public interface CategoryRepository extends MongoRepository<Category, Long> {

	List<Category> findByCategoryName(String name);
}
