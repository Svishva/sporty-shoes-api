package com.sportyshoes.controllers;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.exceptions.MyResourceNotDeletedException;
import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.exceptions.MyResourceNotUpdatedException;
import com.sportyshoes.models.Product;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/all")
	public String getAll() {
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

	@PostMapping("add")
	public String add(@RequestBody Product product) {
		try {
			this.productService.addProduct(product);
			return "New Product record created successfully.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@PatchMapping("/{productId}/update/name")
	public String updateName(@PathVariable String productId, @RequestBody Product product) {
		try {
			log.info("updateName called \tproductId=" + productId);
			log.info("RequestBody =" + product);
			product.setProductId(productId);
			this.productService.updateProduct(product);

			return String.format("Record of Product with ID %s updated successfully.", product.getProductId());
		} catch (MyResourceNotFoundException | MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	@PatchMapping("/{productId}/update/msrp")
	public String updateMsrp(@PathVariable String productId, @RequestBody Product product) {
		try {
			log.info("updateMsrp called \tproductId=" + productId);
			log.info("RequestBody =" + product);
			product.setProductId(productId);
			this.productService.updateProduct(product);

			return String.format("Record of Product with ID %s updated successfully.", product.getProductId());
		} catch (MyResourceNotFoundException | MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	@PatchMapping("/{productId}/update/quantity")
	public String updateQuantity(@PathVariable String productId, @RequestBody Product product) {
		try {
			log.info("updateQuantity called \tproductId=" + productId);
			log.info("RequestBody =" + product);
			product.setProductId(productId);
			this.productService.updateProduct(product);

			return String.format("Record of Product with ID %s updated successfully.", product.getProductId());
		} catch (MyResourceNotFoundException | MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	@PatchMapping("/{productId}/update/vendor")
	public String updateVendor(@PathVariable String productId, @RequestBody Product product) {
		try {
			log.info("updateVendor called \tproductId=" + productId);
			log.info("RequestBody =" + product);
			product.setProductId(productId);
			this.productService.updateProduct(product);

			return String.format("Record of Product with ID %s updated successfully.", product.getProductId());
		} catch (MyResourceNotFoundException | MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	@DeleteMapping("/{productId}/delete")
	public String delete(@PathVariable String productId) {
		try {
			this.productService.deleteProduct(productId);
			return String.format("Record of Product  with ID %s deleted successfully", productId);
		} catch (MyResourceNotDeletedException e) {
			return e.getMessage();
		}
	}

	@GetMapping("/{productId}/order/all")
	public String bringAllOrdersOfaProduct(@PathVariable String productId) {
		try {
			log.info("bringAllOrdersOfaProduct called \tsearchProductID=" + productId);

			return this.orderService.getAllOrdersOfaProduct(productId).stream().map(String::valueOf)
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
