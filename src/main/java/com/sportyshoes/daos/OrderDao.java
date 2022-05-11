package com.sportyshoes.daos;

import java.util.List;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.Order;

public interface OrderDao {

	Integer addOrder(Order order) throws DatabaseOperationException;

	List<Order> getOrdersByUserId(String userId) throws DatabaseOperationException;

	List<Order> getAllOrder() throws DatabaseOperationException;

	List<Order> getAllOrdersOfaProduct(String productId) throws DatabaseOperationException;

}
