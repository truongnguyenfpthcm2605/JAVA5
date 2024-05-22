package com.poly.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import com.poly.app.enity.Product;

public interface ProductService {
	Product save(Product product);
	Optional<Product> findById(Integer id);
	void deleteById(Integer id);
	List<Product> findAll();
	List<Product> findAllSort(Sort sort);
	Page<Product> findAllPage(Pageable page);
	 List<Product> findByKeywords(@Param("keywords") String  keywords);
	 List<Product> findProductsByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}	
