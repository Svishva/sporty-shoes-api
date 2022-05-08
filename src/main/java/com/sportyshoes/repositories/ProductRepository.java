package com.sportyshoes.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

}
