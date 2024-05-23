package com.mudita.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudita.os.api.entity.Order;
import com.mudita.os.api.repository.OrderRepository;

@Service
public class OrderService {
	
	
	
	@Autowired
	private OrderRepository orderRepository;

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
