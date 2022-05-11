package com.sportyshoes.daos;

import java.util.List;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.User;

public interface UserDao {

	List<User> getUserByUserId(String name) throws DatabaseOperationException;

	Integer updateUserPassword(User user) throws DatabaseOperationException;

	List<User> getAllUsers() throws DatabaseOperationException;

	List<User> searchUserByName(String userName) throws DatabaseOperationException;

	Integer updateUserName(User user) throws DatabaseOperationException;

	Integer signIn(User user) throws DatabaseOperationException;

	Integer signUp(User user) throws DatabaseOperationException;

}
