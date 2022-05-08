package com.sportyshoes.controllers;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/all")
	public String getAllProducts() {
		try {
			return this.productService.getAllProducts().stream().map(String::valueOf).collect(Collectors.joining("\n"));
		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	@GetMapping("/search")
	public String searchProductByName(@RequestParam String name) {
		try {
			log.info("searchProduct called \tsearchProductName =" + name);

			return this.productService.searchProductByName(name).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@GetMapping("/{productId}")
	public String searchProductByProductId(@PathVariable String productId) {
		try {
			log.info("searchProductByProductId called \tsearchProductID=" + productId);

			return this.productService.searchProductByProductId(productId).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
