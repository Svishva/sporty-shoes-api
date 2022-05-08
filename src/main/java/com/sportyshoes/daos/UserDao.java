package com.sportyshoes.daos;

import java.util.List;

import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.models.User;

public interface UserDao {

	List<User> searchUserByName(String name) throws DatabaseOperationException;

}
