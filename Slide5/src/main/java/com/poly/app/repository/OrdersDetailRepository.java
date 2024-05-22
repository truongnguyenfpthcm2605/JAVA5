package com.poly.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.poly.app.enity.OrderDetails;

public interface OrdersDetailRepository extends CrudRepository<OrderDetails, Long> {

}
