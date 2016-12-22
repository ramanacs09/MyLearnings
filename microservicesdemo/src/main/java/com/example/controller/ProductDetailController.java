package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ProductDetail;
import com.example.service.ProductDetailService;


/**
 * 
 * @author user
 * Sample Controller program to test
 *
 */
@RestController
@RequestMapping("/products")
public class ProductDetailController {
	
	@Autowired
	private ProductDetailService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<ProductDetail> getAvailableProductsDetails(){
		return service.getAllProductDetails();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductDetail create(@RequestBody ProductDetail detail){
		return service.create(detail);
	}
	
	@RequestMapping(value="/{term}",method=RequestMethod.GET)
	public List<ProductDetail> getProductDetailsUsingSearchTerm(@RequestParam(value="search",defaultValue="productName" ,required=false) String term){
		return service.getSearchedProductDetails(term);
	}
	
}
