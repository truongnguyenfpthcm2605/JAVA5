package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.app.enity.OrderDetails;
import com.poly.app.repository.OrdersDetailRepository;
import com.poly.app.service.OrdersDetailService;
@Service
public class OrdersDetailServiceImpl implements OrdersDetailService {
	@Autowired
	OrdersDetailRepository dao;
	@Override
	public OrderDetails save(OrderDetails orderDetails) {
		return dao.save(orderDetails);
	}

	@Override
	public Optional<OrderDetails> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<OrderDetails> findAll() {
		return (List<OrderDetails>)dao.findAll();
	}

}
