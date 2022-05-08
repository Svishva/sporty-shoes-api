package com.sportyshoes.services;

import org.springframework.stereotype.Component;

import com.sportyshoes.daos.OrderDao;

@Component
public class OrderService {

	private OrderDao orderDao;

	public OrderService(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

}
