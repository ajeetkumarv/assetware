package com.assetware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.assetware.beans.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User u = new User();
		
		u.setEmpId(rs.getString("emp_id"));
		u.setFullName(rs.getString("name"));
		u.setUsername(rs.getString("username"));
		u.setDept(rs.getString("dept"));
		u.setDesignation(rs.getString("designation"));
		u.setContactNo(rs.getString("contact_no"));
		u.setEmail(rs.getString("email"));
		u.setLocation(rs.getString("location"));
		u.setRemark(rs.getString("remark"));
		u.setCreatedBy(rs.getString("created_by"));
		
		Timestamp timestamp = rs.getTimestamp("created_on");
		
		if (timestamp != null) {
			LocalDateTime updatedOn = timestamp.toLocalDateTime();
			u.setCreatedOn(updatedOn);
		}
		return u;
	}
	
}
