package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Product;
import com.poly.app.repository.ProductRepository;
import com.poly.app.service.ProductService;
@Service
public class ProductServiceImpl  implements ProductService {
	@Autowired
	ProductRepository dao;
	@Override
	public Product save(Product product) {
		return dao.save(product);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) dao.findAll();
	}

	@Override
	public List<Product> findAllSort(Sort sort) {
		return (List<Product>) dao.findAll(sort);
	}

	@Override
	public Page<Product> findAllPage(Pageable page) {
		return dao.findAll(page);
	}
	
	public  List<Product> findbyName(String key) {
		return dao.findByKeywords(key);
	}
	
	public List<Product> findPriceTT(Double min, Double max) {
		return dao.findProductsByPriceRange(min, max);
	}

	@Override
	public  List<Product> findByKeywords(String keywords) {
		return dao.findByKeywords(keywords);
	}

	@Override
	public List<Product> findProductsByPriceRange(Double minPrice, Double maxPrice) {
		return dao.findProductsByPriceRange(minPrice, maxPrice);
	}
}
