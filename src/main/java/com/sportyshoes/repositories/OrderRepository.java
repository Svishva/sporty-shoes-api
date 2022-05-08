package com.sportyshoes.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.OrderDao;

@Component
public class OrderRepository implements OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

}
