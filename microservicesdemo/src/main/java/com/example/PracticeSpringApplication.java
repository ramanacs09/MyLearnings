package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSpringApplication {

	/*@Autowired
	private ProductDetailRepository repository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringApplication.class);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		ProductDetail detail = new ProductDetail();
		detail.setProductId("ABCD1234");
		detail.setProductName("Building Microservices");
		detail.setShortDescription("A book about microservices");
		detail.setLongDescription("This book gives the complete detail about building, deploying microservices");
		detail.setInventoryId("009178461");
		
		repository.save(detail);
		
		System.out.println("Details about product:\n");
		System.out.println("***********************************************");
		for(ProductDetail productDetail : repository.findAll()){
			System.out.println(productDetail);
		}
		
	}*/
}
