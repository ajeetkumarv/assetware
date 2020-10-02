package com.assetware.service;

import java.time.LocalDateTime;
import java.util.List;

import com.assetware.beans.AssetUserMapData;
import com.assetware.beans.User;
import com.assetware.dao.MapAssetUserDao;
import com.assetware.dao.impl.MapAssetUserDaoImpl;

public class MapAssetUserService {
	
	private MapAssetUserDao dao = new MapAssetUserDaoImpl();

	public void mapAssetUser(String serialNo, String empId, String createdBy) {
		dao.mapAssetUser(serialNo, empId, createdBy);
	}
	
	public int detachAssetUser(String serialNo, String empId, String updatedBy, LocalDateTime endDate) {
		return dao.detachAssetUser(serialNo, empId, updatedBy, endDate);
	}
	
	public User getAssetUserDetails(String serialNo) {
		User user = dao.getAssetUserDetails(serialNo);
		
		return user;
	}
	
	public List<AssetUserMapData> getUserHistory(String serialNo) {
		return dao.getUserHistory(serialNo);
	}
	
	private MapAssetUserService() {}
	
	private static class SingletonHolder{
        private static final MapAssetUserService INSTANCE = new MapAssetUserService();
    }
    
    public static MapAssetUserService getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
