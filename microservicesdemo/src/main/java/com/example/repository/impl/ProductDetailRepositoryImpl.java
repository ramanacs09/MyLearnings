package com.example.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.entity.ProductDetail;
import com.example.repository.ProductDetailCustomRepository;

public class ProductDetailRepositoryImpl implements ProductDetailCustomRepository{
	
	@Autowired
	private MongoTemplate template;
	
	public List<ProductDetail> searchProductDetails(String term){
		Criteria criteria = Criteria.where("productName").is(term).orOperator(Criteria.where("longDescription").is(term));
		return template.find(Query.query(criteria), ProductDetail.class);
	}

}
