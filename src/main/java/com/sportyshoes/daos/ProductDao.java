package com.sportyshoes.daos;

import java.util.List;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.Product;

public interface ProductDao {

	List<Product> getAllProducts() throws DatabaseOperationException;

	List<Product> searchProductByName(String name) throws DatabaseOperationException;

	List<Product> searchProductByProductId(String productId) throws DatabaseOperationException;

	Integer addProduct(Product product) throws DatabaseOperationException;

	Integer updateProduct(Product product) throws DatabaseOperationException;

	Integer deleteProductById(String productId) throws DatabaseOperationException;

}
