package com.cognizant.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
}
