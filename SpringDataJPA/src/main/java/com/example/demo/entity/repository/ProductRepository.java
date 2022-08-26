package com.example.demo.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	List<Product> findByName(String name);

}
