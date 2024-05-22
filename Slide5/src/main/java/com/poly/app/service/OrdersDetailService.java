package com.poly.app.service;

import java.util.List;
import java.util.Optional;



import com.poly.app.enity.OrderDetails;

public interface OrdersDetailService {
	OrderDetails save(OrderDetails orderDetails);
	Optional<OrderDetails> findById(Long id);
	void deleteById(Long id);
	List<OrderDetails> findAll();
}
