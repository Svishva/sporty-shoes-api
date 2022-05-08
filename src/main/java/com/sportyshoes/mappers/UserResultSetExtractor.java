package com.sportyshoes.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sportyshoes.models.User;

public class UserResultSetExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		return User.builder().userId(rs.getString("user_id")).name(rs.getString("name"))
				.password(rs.getString("password")).createTime(rs.getTimestamp("create_time")).build();
	}

}
