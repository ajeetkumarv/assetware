package com.assetware.dao;

import java.util.List;
import java.util.Map;

import com.assetware.beans.Asset;

public interface AssetDao {
	public void create(Asset asset, boolean formDataChangedOrNew);
	public void create(List<Asset> assets);
	public List<String> getAssetTypes();
	
	public List<Asset> simpleSearch(String searchSql, Object[] params);
	public List<String> getAssetStatuses();
	public List<String> getDepartments();
	public List<String> getAttachmentFilenames(String srNo);
	public Map<String, List<String>> getAttachmentFilenames(List<String> srNos);
	public List<Asset> getAudits(String serialNo);
	Integer getCount(String query, Object[] params);
	public List<String> getOs();
}
