package com.cognizant.ecommerce.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "description", length = 500)
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "category_id")
	private long categoryId;
	@Column(name = "image_url", length = 255)
	private String imageUrl;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "dop")
	private LocalDate dop;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	@Column(name = "availability")
	private boolean availability;
	@Column(name = "quantity")
	private int quantity;	
}
