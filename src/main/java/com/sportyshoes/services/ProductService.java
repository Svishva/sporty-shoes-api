package com.sportyshoes.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sportyshoes.daos.ProductDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.models.Product;

@Component
public class ProductService {

	private ProductDao productDao;

	public ProductService(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public List<Product> getAllProducts() throws MyResourceNotFoundException {
		try {
			List<Product> products = this.productDao.getAllProducts();

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}
			return products;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("Something went wrong when fetching the Product record!");
		}
	}

	public List<Product> searchProductByName(String name) throws MyResourceNotFoundException {
		try {

			List<Product> products = this.productDao.searchProductByName(name);

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No Records Found!");
		}
	}

	public List<Product> searchProductByProductId(String productId) throws MyResourceNotFoundException {
		try {

			List<Product> products = this.productDao.searchProductByProductId(productId);

			if (products == null || products.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}

			return products;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No Records Found!");
		}
	}

}
