package com.assetware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.assetware.beans.AWUser;

public class AWUserMapper implements RowMapper<AWUser> {

	@Override
	public AWUser mapRow(ResultSet rs, int rowNum) throws SQLException{
		AWUser user = new AWUser(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		return user;
	}
	
}
