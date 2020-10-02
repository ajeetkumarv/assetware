package com.assetware.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.assetware.beans.User;
import com.assetware.dao.UserDao;
import com.assetware.utils.ServletUtils;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl() {
		System.out.println("Initilizing Data source.");
		this.jdbcTemplate = new JdbcTemplate(ServletUtils.mysqlDataSource());
	}
	
	@Override
	public void create(User u) {
		jdbcTemplate.update(QueryConstants.INSERT_USER, u.getFullName(), u.getUsername(), u.getDept(), u.getDesignation(),
				u.getEmpId(), u.getContactNo(), u.getEmail(), u.getLocation(), u.getRemark(), u.getCreatedBy(), 
				
				u.getDept(), u.getDesignation(), u.getContactNo(), u.getEmail(), u.getLocation(), u.getRemark());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> search() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
