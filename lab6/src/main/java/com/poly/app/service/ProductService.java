package com.poly.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.app.enity.Product;
import com.poly.app.enity.Report;

public interface ProductService {
	Product save(Product product);
	Optional<Product> findById(Integer id);
	void deleteById(Integer id);
	List<Product> findAll();
	List<Product> findAllSort(Sort sort);
	Page<Product> findAllPage(Pageable page);
	List<Product> findByPriceBetween(Double min, Double max);
	Page<Product> findByKeywords(String keywords, Pageable pageable);
	List<Report>  getInventoryByCategory();
	List<Product> findByPrice(double minPrice, double maxPrice);
	Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}	
