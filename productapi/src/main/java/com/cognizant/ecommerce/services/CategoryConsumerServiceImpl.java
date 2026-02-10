package com.cognizant.ecommerce.services;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@KafkaListener(topics = "category", groupId = "category-group")
@Slf4j
public class CategoryConsumerServiceImpl implements CategoryConsumerService {

	@KafkaHandler(isDefault = true)
	@Override
	public void consumeCategoryMessage(String message) {
		// TODO Auto-generated method stub
		log.info("Received category message: {}", message);
	}

}
