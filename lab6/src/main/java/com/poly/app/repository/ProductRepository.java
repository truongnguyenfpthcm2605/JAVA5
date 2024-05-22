package com.poly.app.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.poly.app.enity.Product;
import com.poly.app.enity.Report;

public interface ProductRepository extends JpaRepository<Product, Integer>  {
	
	 List<Product> findByPriceBetween(Double min, Double max) ;
	 
	 
	 @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	 List<Product> findByPrice(double minPrice, double maxPrice);
	 
	 @Query("SELECT o FROM Product o WHERE o.name LIKE :keywords")
	 Page<Product> findByKeywords(@Param("keywords") String  keywords, Pageable pageable);
	 
	 @Query("SELECT new Report(o.category, sum(o.price), count(o))"
		        + " FROM Product o "
		        + " GROUP BY o.category"
		        + " ORDER BY sum(o.price) DESC")
		List<Report> getInventoryByCategory();
	
	 Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	
}
