package com.sportyshoes.daos;

import java.util.List;
import java.util.Optional;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.Product;

public interface ProductDao {

	List<Product> getAllProducts() throws DatabaseOperationException;
	List<Product> searchProductByName(String name) throws DatabaseOperationException;
	List<Product> searchProductByProductId(String productId) throws DatabaseOperationException;

}
