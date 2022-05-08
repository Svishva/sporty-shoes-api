package com.sportyshoes.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.exceptions.MyResourceNotFoundException;
import com.sportyshoes.exceptions.MyResourceNotUpdatedException;
import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;

@Component
public class UserService {

	@Autowired
	private UserDao userRepository;

	public UserService(UserDao userDao) {
		super();
		this.userRepository = userDao;
	}

	public List<User> getUserByUserId(String userId) throws MyResourceNotFoundException {
		try {

			List<User> users = this.userRepository.getUserByUserId(userId);

			if (users == null || users.isEmpty()) {
				throw new MyResourceNotFoundException("No Product found");
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No Records Found!");
		}
	}

	public void updateUserPassword(User user) throws MyResourceNotUpdatedException {
		try {
			Integer recordsUpdated = this.userRepository.updateUserPassword(user);
			if (recordsUpdated == 0) {
				throw new MyResourceNotUpdatedException("Could not update User Password!!!");
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotUpdatedException("Something went wrong when updating the worker records!");
		}
	}

	public List<User> getAllUsers() throws MyResourceNotFoundException {
		try {
			List<User> users = this.userRepository.getAllUsers();

			if (users == null || users.isEmpty()) {
				throw new MyResourceNotFoundException("No Users found");
			}
			return users;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("Something went wrong when fetching the Product record!");
		}
	}

	public List<User> searchUserByName(String userName) throws MyResourceNotFoundException {
		try {

			List<User> users = this.userRepository.searchUserByName(userName);

			if (users == null || users.isEmpty()) {
				throw new MyResourceNotFoundException("No User found");
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("No User Found!");
		}
	}

}
