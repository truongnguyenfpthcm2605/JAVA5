package com.poly.app.service;

import java.util.List;
import java.util.Optional;



import com.poly.app.enity.Orders;

public interface OrdersServie {
		Orders save(Orders orders);
		Optional<Orders> findById(Long id);
		void deleteById(Long id);
		List<Orders> findAll();
}
