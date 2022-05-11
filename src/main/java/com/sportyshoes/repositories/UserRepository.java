package com.sportyshoes.repositories;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.exceptions.DatabaseOperationException;
import com.sportyshoes.mappers.UserRowMapper;
import com.sportyshoes.models.User;

@Component
public class UserRepository implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUserByUserId(String name) throws DatabaseOperationException {

		String searchUserByNameFormat = new StringJoiner("").add("""
				SELECT  user_id,  name,  `password`,  create_time
				FROM  users u
				WHERE  u.user_id = '""").add(name).add("'").toString();

		List<User> users = Collections.emptyList();

		try {
			users = jdbcTemplate.query(searchUserByNameFormat, new UserRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while searching user by User ID", e);
		}

		return users;
	}

	@Override
	public Integer updateUserPassword(User user) throws DatabaseOperationException {

		String updateUserPasswordFormat = new StringJoiner("").add("UPDATE users SET `password` = '")
				.add(user.getPassword()).add("' WHERE user_id = '").add(user.getUserId()).add("'").toString();

		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(updateUserPasswordFormat);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while update User Password User ID", e);
		}

		return recordsUpdated;
	}

	@Override
	public List<User> getAllUsers() throws DatabaseOperationException {
		String getAllUsersFormat = """
				SELECT user_id, name, `password`, create_time
				FROM users""";

		List<User> users = Collections.emptyList();

		try {
			users = jdbcTemplate.query(getAllUsersFormat, new UserRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all Users records", e);
		}

		return users;
	}

	@Override
	public List<User> searchUserByName(String userName) throws DatabaseOperationException {

		String searchUserByNameFormat = new StringJoiner("").add("""
				SELECT  user_id,  name,  `password`,  create_time
				FROM  users u
				WHERE  u.name like '%""").add(userName).add("%'").toString();

		List<User> users = Collections.emptyList();

		try {
			users = jdbcTemplate.query(searchUserByNameFormat, new UserRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while searching user by User ID", e);
		}

		return users;
	}

	@Override
	public Integer updateUserName(User user) throws DatabaseOperationException {

		String updateUserNameFormat = new StringJoiner("").add("UPDATE users SET `name` = '").add(user.getName())
				.add("' WHERE user_id = '").add(user.getUserId()).add("'").toString();

		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(updateUserNameFormat);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while update User name User ID", e);
		}

		return recordsUpdated;
	}

	@Override
	public Integer signIn(User user) throws DatabaseOperationException {

		String searchUserByNameFormat = """
				SELECT  user_id,  name,  `password`,  create_time
				FROM  users u
				WHERE  u.user_id = ? and `password` = ?""";

		List<User> users = Collections.emptyList();

		try {
			users = jdbcTemplate.query(searchUserByNameFormat, new Object[] { user.getUserId(), user.getPassword() },
					new UserRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while searching user by User ID", e);
		}

		return users.size();
	}

	@Override
	public Integer signUp(User user) throws DatabaseOperationException {
		String insertUserFormat = """
				INSERT INTO
				users (user_id,name,`password`)
				VALUES (?, ?, ?)""";

		Integer recordsInserted = 0;

		try {
			recordsInserted = jdbcTemplate.update(insertUserFormat, user.getUserId(), user.getName(),
					user.getPassword());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while inserting a new worker record!", e);
		}
		return recordsInserted;
	}
}
