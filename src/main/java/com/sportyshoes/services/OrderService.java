package com.sportyshoes.services;

import static com.sportyshoes.utils.RandomDataGeneratorUtil.getUniqueId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.OrderDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.exceptions.MyResourceNotCreatedException;
import com.sportyshoes.models.Order;

@Component
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public void createOrder(Order order) throws MyResourceNotCreatedException {
		try {

			if (order != null && order.getOrderId() == null) {
				order.setOrderId(getUniqueId());
			}
			Integer recordsInserted = this.orderDao.addOrder(order);

			if (recordsInserted == 0) {
				throw new MyResourceNotCreatedException("Could not create new Order record!");
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotCreatedException("Something went wrong when creating new Order record!");
		}
	}

}
