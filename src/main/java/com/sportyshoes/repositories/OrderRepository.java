package com.sportyshoes.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.OrderDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.mappers.OrderRowMapper;
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

	@Override
	public List<Order> getOrdersByUserId(String userId) throws DatabaseOperationException {
		String getAllUsersFormat = """
					SELECT
					order_id,
					quantity,
					user_id,
					order_date,
					create_time,
					product_id
				FROM
					orders u
				WHERE
					u.user_id = ?""";

		List<Order> orders = Collections.emptyList();

		try {
			orders = jdbcTemplate.query(getAllUsersFormat, new Object[] { userId }, new OrderRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Users records", e);
		}

		return orders;
	}

	@Override
	public List<Order> getAllOrder() throws DatabaseOperationException {
		String getAllUsersFormat = """
				SELECT
					order_id,
					quantity,
					user_id,
					order_date,
					create_time,
					product_id
				FROM
					orders""";

		List<Order> orders = Collections.emptyList();

		try {
			orders = jdbcTemplate.query(getAllUsersFormat, new OrderRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Users records", e);
		}

		return orders;
	}

	@Override
	public List<Order> getAllOrdersOfaProduct(String productId) throws DatabaseOperationException {
		String getAllUsersFormat = """
					SELECT
					order_id,
					quantity,
					user_id,
					order_date,
					create_time,
					product_id
				FROM
					orders u
				WHERE
					u.product_id = ?""";

		List<Order> orders = Collections.emptyList();

		try {
			orders = jdbcTemplate.query(getAllUsersFormat, new Object[] { productId }, new OrderRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Users records", e);
		}

		return orders;
	}

}
