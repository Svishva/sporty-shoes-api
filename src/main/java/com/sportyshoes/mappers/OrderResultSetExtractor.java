package com.sportyshoes.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sportyshoes.models.Order;

public class OrderResultSetExtractor implements ResultSetExtractor<Order> {

	@Override
	public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
		return Order.builder().orderId(rs.getString("order_id")).quantity(rs.getInt("quantity"))
				.userId(rs.getString("user_id")).orderDate(rs.getTimestamp("order_date").toLocalDateTime())
				.createTime(rs.getTimestamp("create_time")).productId(rs.getString("product_id")).build();
	}

}
