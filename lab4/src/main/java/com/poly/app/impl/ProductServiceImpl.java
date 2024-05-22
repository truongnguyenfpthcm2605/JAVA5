package com.poly.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.app.enity.Product;
import com.poly.app.service.ProductService;
@Service
public class ProductServiceImpl  implements ProductService{
	
	public static List<Product> listproduct = new ArrayList<>();
	static{
		listproduct.add(new Product(1, "Iphone 7", "iphone.jpg", 4000));
		listproduct.add(new Product(2, "Iphone 6s", "iphone.jpg", 3000));
		listproduct.add(new Product(3, "Iphone 5", "iphone.jpg", 2000));
		listproduct.add(new Product(4, "Iphone 13", "iphone.jpg", 12000));
		listproduct.add(new Product(5, "Iphone 12", "iphone.jpg", 10000));
		listproduct.add(new Product(6, "Iphone 13 pro max", "iphone.jpg", 15000));
		listproduct.add(new Product(7, "Iphone Xs Max", "iphone.jpg", 8000));
		listproduct.add(new Product(8, "Iphone 14", "iphone.jpg", 14000));
		listproduct.add(new Product(9, "Iphone 8 plus", "iphone.jpg", 7000));
		listproduct.add(new Product(10, "Iphone 14 plus", "iphone.jpg", 15500));	
	}
	@Override
	public Product insert(Product p) {
		
		return null;
	}

	@Override
	public Product update(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return listproduct;
	}

	@Override
	public Product getByProduct(Integer id) {
	    return listproduct.stream()
	            .filter(product -> product.getId().equals(id))
	            .findFirst()
	            .orElse(null);
	}


}
