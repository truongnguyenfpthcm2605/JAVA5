package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Orders;
import com.poly.app.repository.OrdersRepository;
import com.poly.app.service.OrdersServie;
@Service
public class OrdersServiceImpl implements OrdersServie{
	@Autowired
	OrdersRepository dao;
	@Override
	public Orders save(Orders orders) {
		return dao.save(orders);
	}

	@Override
	public Optional<Orders> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Orders> findAll() {
		return (List<Orders>)dao.findAll();
	}

}
