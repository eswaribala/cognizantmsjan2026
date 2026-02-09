package com.cognizant.ecommerce.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categories")
public class Category { 
	@BsonId
	private long categoryId;
	
	private String categoryName;
	
}
