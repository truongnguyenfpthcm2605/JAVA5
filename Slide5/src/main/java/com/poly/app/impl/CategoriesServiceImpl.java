package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Categories;
import com.poly.app.repository.CategoriesRepository;
import com.poly.app.service.CategoriesService;
@Service
public class CategoriesServiceImpl  implements CategoriesService{
		@Autowired
		CategoriesRepository dao;

		@Override
		public Categories save(Categories categories) {
				return dao.save(categories);
		}

		@Override
		public Optional<Categories> findById(String id) {
			return dao.findById(id);
		}

		@Override
		public void deleteById(String id) {
			dao.deleteById(id);
			
		}

		@Override
		public List<Categories> findAll() {
			return (List<Categories>)dao.findAll();
		}
}
