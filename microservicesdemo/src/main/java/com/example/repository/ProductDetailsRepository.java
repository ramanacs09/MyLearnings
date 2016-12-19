package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.ProductDetail;

public interface ProductDetailsRepository extends MongoRepository<ProductDetail, String>, ProductDetailCustomRepository{
	
}
