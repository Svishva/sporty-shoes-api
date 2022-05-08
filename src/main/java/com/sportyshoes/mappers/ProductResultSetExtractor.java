package com.sportyshoes.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sportyshoes.models.Product;

public class ProductResultSetExtractor implements ResultSetExtractor<Product> {

	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		return Product.builder().productId(rs.getString("product_id")).name(rs.getString("name"))
				.msrp(rs.getBigDecimal("msrp")).quantityInStock(rs.getInt("quantity_in_stock"))
				.productVendor(rs.getString("product_vendor")).createTime(rs.getTimestamp("create_time")).build();
	}

}
