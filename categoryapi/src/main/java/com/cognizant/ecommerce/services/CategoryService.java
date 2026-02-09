package com.cognizant.ecommerce.services;

import java.util.List;

import com.cognizant.ecommerce.exceptions.CategoryNullException;
import com.cognizant.ecommerce.models.Category;


public interface CategoryService {
	Category addCategory(Category category) throws CategoryNullException;
	List<Category> getAllCategories();
	Category getCategoryById(long id);
	Category getCategoryByName(String name);
	Category updateCategory(long id, String name);
	boolean deleteCategory(long id);

}
