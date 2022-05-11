package com.sportyshoes.controllers;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping("/all/sorted")
	public String getAllSorted(@RequestParam String key, @RequestParam String ordering) {
		try {
			return this.orderService.getAllOrderSorted(key, ordering).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

}
