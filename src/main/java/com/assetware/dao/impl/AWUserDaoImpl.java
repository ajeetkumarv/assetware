package com.assetware.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.assetware.beans.AWUser;
import com.assetware.dao.AWUserDao;
import com.assetware.exception.UserDetailExistException;
import com.assetware.mapper.AWUserMapper;
import com.assetware.utils.ServletUtils;

public class AWUserDaoImpl implements AWUserDao {

	private JdbcTemplate jdbcTemplate;
	
	public AWUserDaoImpl() {
		System.out.println("Initilizing Data source.");
		this.jdbcTemplate = new JdbcTemplate(ServletUtils.mysqlDataSource());
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(AWUser user) throws UserDetailExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AWUser login(String username, String password) {

		AWUser user = null;
		try {
			user = jdbcTemplate.queryForObject(QueryConstants.GET_AWUSER,
					new Object[] {username, password},
					new AWUserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No details found for serial: " + username);
			//e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int changePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
