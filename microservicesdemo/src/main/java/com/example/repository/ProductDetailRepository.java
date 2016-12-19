package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ProductDetail;

@Repository
public interface ProductDetailRepository extends MongoRepository<ProductDetail, String>{

	@Query("{$or:[{'productName':?0},{'longDescription':?0}]}")
	List<ProductDetail> search(String term);
	
}
