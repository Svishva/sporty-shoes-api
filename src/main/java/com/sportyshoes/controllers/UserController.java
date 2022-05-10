package com.sportyshoes.controllers;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.models.Order;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/all")
	public String getAllUsers() {
		try {
			log.info("getAllUsers called");
			return this.userService.getAllUsers().stream().map(String::valueOf).collect(Collectors.joining("\n"));
		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	@GetMapping("/search")
	public String searchUserByName(@RequestParam String name) {
		try {
			log.info("searchUserByName called \tname =" + name);

			return this.userService.searchUserByName(name).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@PostMapping("/{userId}/product/{productId}/order")
	public String createOrder(@PathVariable String userId, @PathVariable String productId,
			@RequestParam Integer quantity) {
		try {
			log.info("createOrder called \tuserId =" + userId + "\t productId =" + productId + "\t quantityInStock ="
					+ quantity);

			Order order = Order.builder().userId(userId).productId(productId).quantity(quantity).build();

			this.orderService.createOrder(order);
			return "New Order created successfully.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@GetMapping("/{userId}")
	public String getUserByUserId(@PathVariable String userId) {
		try {
			log.info("getUserByUserId called \tuserId =" + userId);

			return this.userService.getUserByUserId(userId).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
