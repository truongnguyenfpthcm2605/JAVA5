package com.poly.app.service;

import java.util.List;

import com.poly.app.enity.Product;

public interface ProductService {
		Product insert(Product p);
		Product update(Product p);
		Boolean delete(Integer id);
		List<Product> getAllProduct();
		Product getByProduct(Integer id);
}
