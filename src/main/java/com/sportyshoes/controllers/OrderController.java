package com.sportyshoes.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

}
