package com.poly.app.service;

import java.util.List;
import java.util.Optional;
import com.poly.app.enity.Categories;

public interface CategoriesService {
		Categories save(Categories categories) ;
		Optional<Categories> findById(String id);
		void deleteById(String id);
		List<Categories> findAll();
}
