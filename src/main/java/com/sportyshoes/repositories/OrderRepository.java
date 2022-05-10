package com.sportyshoes.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.OrderDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.Order;

@Component
public class OrderRepository implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer addOrder(Order order) throws DatabaseOperationException {
		String insertOrderFormat = """
				INSERT INTO
				orders
				(order_id,
				quantity,
				user_id,
				order_date,
				product_id)
				VALUES (?, ?, ?, NOW(), ?)""";

		Integer recordsInserted = 0;
		try {
			recordsInserted = jdbcTemplate.update(insertOrderFormat, order.getOrderId(), order.getQuantity(),
					order.getUserId(), order.getProductId());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while inserting a new worker record!", e);
		}
		return recordsInserted;
	}

}
