package com.sportyshoes.daos;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.Order;

public interface OrderDao {

	Integer addOrder(Order order) throws DatabaseOperationException;

	
}
