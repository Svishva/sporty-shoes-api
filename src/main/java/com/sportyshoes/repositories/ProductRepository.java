package com.sportyshoes.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.ProductDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.mappers.ProductRowMapper;
import com.sportyshoes.models.Product;

@Component
public class ProductRepository implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() throws DatabaseOperationException {
		String getProductFormat = """
				SELECT product_id,  name,  msrp,  quantity_in_stock,  product_vendor,  create_time
				FROM
				products""";

		List<Product> products = Collections.emptyList();

		try {
			products = Optional.ofNullable(jdbcTemplate.query(getProductFormat, new ProductRowMapper()))
					.orElseGet(Collections::emptyList);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Product records", e);
		}

		return products;
	}

	@Override
	public List<Product> searchProductByName(String name) throws DatabaseOperationException {

		String getProductFormat = new StringJoiner("").add("""
				SELECT  product_id,  name,  msrp,  quantity_in_stock,  product_vendor,  create_time
				FROM  products
				WHERE  name like "%""").add(name).add("%\"").toString();

		List<Product> products = Collections.emptyList();

		try {
			products = jdbcTemplate.query(getProductFormat, new ProductRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Product records", e);
		}

		return products;
	}

	@Override
	public List<Product> searchProductByProductId(String productId) throws DatabaseOperationException {

		String getProductFormat = new StringJoiner("").add("""
				SELECT  product_id,  name,  msrp,  quantity_in_stock,  product_vendor,  create_time
				FROM  products
				WHERE  product_id = '""").add(productId).add("'").toString();

		List<Product> products = Collections.emptyList();

		try {
			products = jdbcTemplate.query(getProductFormat, new ProductRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Product records", e);
		}

		return products;
	}

	@Override
	public Integer addProduct(Product product) throws DatabaseOperationException {
		String insertProdcuctFormat = """
				INSERT INTO products
				 (product_id,
				 name,
				 msrp,
				 quantity_in_stock,
				 product_vendor)
				 VALUES (
				   ?, ?, ?, ?, ?
				   )""";

		Integer recordsInserted = 0;

		try {
			recordsInserted = jdbcTemplate.update(insertProdcuctFormat, product.getProductId(), product.getName(),
					product.getMsrp(), product.getQuantityInStock(), product.getProductVendor());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while inserting a new worker record!", e);
		}
		return recordsInserted;
	}

	@Override
	public Integer updateProduct(Product product) throws DatabaseOperationException {
		String updateProductFormat = """
				UPDATE products
				SET
				    name = ?,
				    msrp = ?,
				    quantity_in_stock = ?,
				    product_vendor = ?
				WHERE
				    product_id = ?""";

		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(updateProductFormat, product.getName(), product.getMsrp(),
					product.getQuantityInStock(), product.getProductVendor(), product.getProductId());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(String.format(
					"Exception occurred while updating the record of worker with ID %s", product.getProductId()), e);
		}

		return recordsUpdated;
	}

	@Override
	public Integer deleteProductById(String productId) throws DatabaseOperationException {
		String deleteProductFormat = """
				DELETE
				FROM
					products
				WHERE
					product_id = ?""";

		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(deleteProductFormat, productId);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while deleting the record of worker with ID %s", productId), e);
		}

		return recordsUpdated;
	}

}
