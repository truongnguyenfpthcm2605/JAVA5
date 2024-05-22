package com.poly.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.app.enity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {
	@Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findProductsByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
	
	@Query("SELECT o FROM Product o WHERE o.name = :keywords")
	 List<Product> findByKeywords(@Param("keywords") String  keywords);
}
