package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Product;
import com.poly.app.enity.Report;
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

	@Override
	public List<Product> findByPriceBetween(Double min, Double max) {
		return dao.findByPriceBetween(min, max);
	}

	@Override
	public Page<Product> findByKeywords(String keywords, Pageable pageable) {
		return dao.findByKeywords(keywords, pageable);
	}

	@Override
	public List<Report> getInventoryByCategory() {
		return dao.getInventoryByCategory();
	}

	@Override
	public List<Product> findByPrice(double minPrice, double maxPrice) {
		return dao.findByPrice(minPrice, maxPrice);
	}

	@Override
	public Page<Product> findAllByNameLike(String keywords, Pageable pageable) {
		return dao.findAllByNameLike(keywords, pageable);
	}

}
