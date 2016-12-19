package com.example.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ProductDetail;
import com.example.repository.ProductDetailRepository;
import com.example.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

	@Autowired
	private ProductDetailRepository repository;
	
	@Override
	public Collection<ProductDetail> getAllProductDetails() {
		return repository.findAll();
	}

	@Override
	public ProductDetail create(ProductDetail detail) {
		return repository.save(detail);
	}

	@Override
	public List<ProductDetail> getSearchedProductDetails(String searchTerm) {
		return repository.search(searchTerm);
	}
	
	

}
