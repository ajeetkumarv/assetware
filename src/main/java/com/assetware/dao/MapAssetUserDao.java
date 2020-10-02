package com.assetware.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.assetware.beans.AssetUserMapData;
import com.assetware.beans.User;

public interface MapAssetUserDao {
	public void mapAssetUser(String serialNo, User user);
	public void mapAssetUser(String serialNo, String empId, String createdBy);
	
	public int detachAssetUser(String serialNo, String empId, String updatedBy, LocalDateTime endDate);
	public User getAssetUserDetails(String serialNo);
	public List<AssetUserMapData> getUserHistory(String serialNo);
}
