package com.poly.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Orders;
import com.poly.app.repository.OrdersRepository;
import com.poly.app.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository dao;
	@Override
	public Orders save(Orders orders) {
		return dao.save(orders);
	}

	@Override
	public Orders update(Orders orders) {
		return dao.save(orders);
	}

	@Override
	public Optional<Orders> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Orders> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public Integer getTotalOrders() {
		return dao.getTotalOrders();
	}

	@Override
	public List<Object[]> findListOrders() {
		return dao.findListOrders();
	}

	@Override
	public Optional<List<Orders>> findByKeywords(String key) {
		return dao.findByKeywords(key);
	}

	@Override
	public List<Orders> findAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Optional<List<Orders>> findByStatus(String status) {
		return dao.findByStatus(status);
	}

	@Override
	public Optional<List<Orders>> findByMoths(Integer month) {
		return dao.findByMoths(month);
	}

}
