package com.assetware.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.assetware.beans.AssetUserMapData;
import com.assetware.beans.User;
import com.assetware.dao.MapAssetUserDao;
import com.assetware.mapper.AssetUserMapDataMapper;
import com.assetware.mapper.UserMapper;
import com.assetware.utils.ServletUtils;

public class MapAssetUserDaoImpl implements MapAssetUserDao {

	private JdbcTemplate jdbcTemplate;
	
	public MapAssetUserDaoImpl() {
		this.jdbcTemplate = new JdbcTemplate(ServletUtils.mysqlDataSource());
	}

	@Override
	public void mapAssetUser(String serialNo, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mapAssetUser(String serialNo, String empId, String createdBy) {
		jdbcTemplate.update(QueryConstants.INSERT_ASSET_USER_MAP,
				serialNo, empId, createdBy);
	}

	@Override
	public int detachAssetUser(String serialNo, String empId, String updatedBy, LocalDateTime endDate) {
		int rowsAffected = jdbcTemplate.update(QueryConstants.DETACH_ASSET_USER_MAP,
				endDate, updatedBy, serialNo, empId);
		
		return rowsAffected;
	}

	@Override
	public User getAssetUserDetails(String serialNo) {	
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(QueryConstants.GET_ASSET_USER_DETAILS,
				new Object[] {serialNo}, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No Active user found for serial: " + serialNo);
			//e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<AssetUserMapData> getUserHistory(String serialNo) {
		return jdbcTemplate.query(QueryConstants.GET_ASSET_USER_MAP, new Object[] {serialNo}, new AssetUserMapDataMapper());
	}

}
