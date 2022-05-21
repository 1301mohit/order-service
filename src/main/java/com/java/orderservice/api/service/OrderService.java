package com.java.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.orderservice.api.dao.OrderRepository;
import com.java.orderservice.api.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public Order saveOrder(Order order) {
		return repository.save(order);
	}
	
}
