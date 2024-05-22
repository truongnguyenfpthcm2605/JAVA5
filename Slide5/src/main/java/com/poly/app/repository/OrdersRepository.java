package com.poly.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.poly.app.enity.Orders;

public interface OrdersRepository  extends CrudRepository<Orders, Long>{

}
