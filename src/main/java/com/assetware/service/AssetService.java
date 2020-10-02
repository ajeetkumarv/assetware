package com.assetware.service;

import static com.assetware.utils.AppUtils.isBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.javatuples.Pair;

import com.assetware.beans.Asset;
import com.assetware.dao.AssetDao;
import com.assetware.dao.impl.AssetDaoImpl;

public class AssetService {
	
	private AssetDao assetDao = new AssetDaoImpl();

	public void create(Asset asset, boolean formDataNew) {
		assetDao.create(asset, formDataNew);
	}
	
	public void create(List<Asset> assets) {
		assetDao.create(assets);
	}
	
	public List<Asset> simpleSearch(Asset asset, int pageId, int recordCount) {
		
		String select = "select * from asset where ";
		
		Pair<String, List<Object>> queryWithConditionsAndParams = composeQueryWithConditions(asset, select);
		
		pageId = pageId - 1;
		
		String query = queryWithConditionsAndParams.getValue0() + " order by sr_no limit "
					+ (pageId * recordCount) + ", " + recordCount ;
		
		List<Asset> assets = searchDBForAssets(query, queryWithConditionsAndParams.getValue1().toArray());
		
		return assets;
	}

	public List<Asset> simpleSearch(Asset asset) {
		
		String select = "select * from asset where ";
		
		Pair<String, List<Object>> queryWithConditionsAndParams = composeQueryWithConditions(asset, select);
		
		String query = queryWithConditionsAndParams.getValue0();
		
		List<Asset> assets = searchDBForAssets(query, queryWithConditionsAndParams.getValue1().toArray());
		
		return assets;
	}
	
	private List<Asset> searchDBForAssets(String query, Object[] params) {
		List<Asset> assets = assetDao.simpleSearch(query, params);
		
		//This needs improvement
		for(Asset a: assets) {
			String srNo = a.getSerialNo();
			List<String> attachments = assetDao.getAttachmentFilenames(srNo);
			a.setAttachmentFileNames(attachments);
		}
		
		return assets;
	}
	
	public Integer getTotalRowsInSearch(Asset asset) {
		
		String select = "select count(sr_no) from asset where ";
		
		Pair<String, List<Object>> queryWithConditionsAndParams = composeQueryWithConditions(asset, select);
		
		String query = queryWithConditionsAndParams.getValue0();
		
		System.out.println(query);
		
		return assetDao.getCount(query, queryWithConditionsAndParams.getValue1().toArray());
	}
	
	private Pair<String, List<Object>> composeQueryWithConditions(Asset asset, String baseQuery) {
		StringJoiner sj = new StringJoiner(" and ", baseQuery, "");
		
		List<Object> params = new ArrayList<>();
		
		sj.add("1=1");
		
		if (!isBlank(asset.getAssetType())) {
			sj.add("asset_type = ?");
			params.add(asset.getAssetType());
		}
		
		if (!isBlank(asset.getAssetStatus())) {
			sj.add("asset_status = ?");
			params.add(asset.getAssetStatus());
		}
		if (!isBlank(asset.getSerialNo())) {
			sj.add("sr_no = ?");
			params.add(asset.getSerialNo());
		}
		if (!isBlank(asset.getTag())) {
			sj.add("tag = ?");
			params.add(asset.getTag());
		}
		if (!isBlank(asset.getMake())) {
			sj.add("make = ?");
			params.add(asset.getMake());
		}
		if (!isBlank(asset.getModel())) {
			sj.add("model = ?");
			params.add(asset.getModel());
		}
		if (!isBlank(asset.getStoreCode())) {
			sj.add("store_code = ?");
			params.add(asset.getStoreCode());
		}
		if (!isBlank(asset.getOs())) {
			sj.add("os = ?");
			params.add(asset.getOs());
		}
		if (!isBlank(asset.getMemory())) {
			sj.add("memory = ?");
			params.add(asset.getMemory());
		}
		if (!isBlank(asset.getHardDisk())) {
			sj.add("hard_disk = ?");
			params.add(asset.getHardDisk());
		}
		if (!isBlank(asset.getPoNo())) {
			sj.add("po_no = ?");
			params.add(asset.getPoNo());
		}
		if (asset.getPoDate() != null) {
			sj.add("po_date = ?");
			params.add(asset.getPoDate());
		}
		if (!isBlank(asset.getInvoiceNo())) {
			sj.add("invoice_no = ?");
			params.add(asset.getInvoiceNo());
		}
		if (asset.getInvoiceDate() != null) {
			sj.add("invoice_date = ?");
			params.add(asset.getInvoiceDate());
		}
		if (asset.getRemark() != null) {
			sj.add("remark like '%" + asset.getRemark() + "%'");
		}
		
		Pair<String, List<Object>> pair = Pair.with(sj.toString(), params);
		
		return pair;
	}
	
	public List<Asset> simpleSearchAudit(Asset asset) {
		
		String select = "select * from asset_audit where ";
		
		Pair<String, List<Object>> queryWithConditionsAndParams = composeQueryWithConditions(asset, select);
		
		String query = queryWithConditionsAndParams.getValue0();
		
		query =  query + " order by updated_on desc";
		
		List<Asset> assets = assetDao.simpleSearch(query, queryWithConditionsAndParams.getValue1().toArray());
		
		return assets;
	}
	
	public List<String> getAssetTypes() {
		return assetDao.getAssetTypes();
	}

	public List<String> getAssetStatuses() {
		return assetDao.getAssetStatuses();
	}
	
	public List<String> getDepartments() {
		return assetDao.getDepartments();
	}
	
	public AssetDao getAssetDao() {
		return assetDao;
	}

	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}
	
	public List<String> getAssetAttachment(String srNo) {
		return this.assetDao.getAttachmentFilenames(srNo);
	}

	public List<Asset> getAudits(String serialNo) {
		return this.assetDao.getAudits(serialNo);
	}

	public List<String> getOs() {
		return this.assetDao.getOs();
	}
	
	private AssetService() {}
	
	private static class SingletonHolder{
        private static final AssetService INSTANCE = new AssetService();
    }
    
    public static AssetService getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
