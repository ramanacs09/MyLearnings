package com.example.repository;

import java.util.List;

import com.example.entity.ProductDetail;

public interface ProductDetailCustomRepository {
	public List<ProductDetail> searchProductDetails(String term);
}
