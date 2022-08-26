package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.entity.repository.ProductRepository;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
	}

	@Test
	void saveProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		Product product = new Product();
		product.setName("Printer");
		product.setDescription("Colored Canon Printer");
		product.setPrice(15000);

		repo.save(product);

	}

	@Test
	void readProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		Optional<Product> optionalProduct = repo.findById(2);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			System.out.println(product);
		} else {
			System.out.println("product not present.");
		}
	}

	@Test
	void deleteProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		repo.deleteById(7);
		// repo.deleteById(15);
	}
	
	@Test
	void updateProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		Optional<Product> optionalProduct = repo.findById(4);
		Product product = null;
		if (optionalProduct.isPresent()) {
			product = optionalProduct.get();
			System.out.println(product);
		}
		if (product != null) {
			product.setPrice(12500);
			repo.save(product);
		}
	}
	
	@Test
	void findByName() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = repo.findByName("Printer");
		System.out.println(products);
	}
}
