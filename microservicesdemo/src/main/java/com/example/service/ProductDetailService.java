package com.example.service;

import java.util.Collection;
import java.util.List;

import com.example.entity.ProductDetail;

public interface ProductDetailService {
	public Collection<ProductDetail> getAllProductDetails();
	public ProductDetail create(ProductDetail detail);
	public List<ProductDetail> getSearchedProductDetails(String searchTerm);
}
