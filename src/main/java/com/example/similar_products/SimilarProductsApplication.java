package com.example.similar_products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SimilarProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimilarProductsApplication.class, args);
	}

}
