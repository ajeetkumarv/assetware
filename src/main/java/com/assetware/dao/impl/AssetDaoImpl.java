package com.assetware.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.assetware.beans.Asset;
import com.assetware.dao.AssetDao;
import com.assetware.mapper.AssetMapper;
import com.assetware.utils.ServletUtils;

public class AssetDaoImpl implements AssetDao {

	private JdbcTemplate jdbcTemplate;
	
	public AssetDaoImpl() {
		System.out.println("Initilizing Data source.");
		this.jdbcTemplate = new JdbcTemplate(ServletUtils.mysqlDataSource());
	}
	
	@Override
	public void create(Asset asset, boolean formDataNew) {
		if (!formDataNew) {
			// this is to be moved into asset_audit table
			Asset a = jdbcTemplate.queryForObject("select * from asset where sr_no='" + asset.getSerialNo() + "'",
					new AssetMapper());
			a.setUpdatedBy(asset.getUpdatedBy());
			// ? = 16 value = 18 
			jdbcTemplate.update(QueryConstants.INSERT_ASSET_AUDIT_TRIAL,
					a.getAssetType(), a.getAssetStatus(), a.getSerialNo(), a.getTag(),
					a.getMake(), a.getModel(), a.getStoreCode(), a.getOs(),
					a.getMemory(), a.getHardDisk(), a.getPoNo(), a.getPoDate(),
					a.getInvoiceNo(), a.getInvoiceDate(), a.getRemark(),
					a.getCreatedBy(), a.getCreatedOn(), a.getUpdatedBy());
			
			jdbcTemplate.update("update asset set "
					+ "asset_type = ?, asset_status = ?, tag = ?,"
					+ "make = ?, model = ?, store_code = ?, os = ?, memory = ?, hard_disk = ?,"
					+ "po_no = ?, po_date= ?, invoice_no = ?, invoice_date = ?, remark = ?,"
					+ "updated_by = ?",
					asset.getAssetType(), asset.getAssetStatus(), asset.getTag(),
					asset.getMake(), asset.getModel(), asset.getStoreCode(), asset.getOs(), asset.getMemory(), asset.getHardDisk(),
					asset.getPoNo(), asset.getPoDate(), asset.getInvoiceNo(), asset.getInvoiceDate(), asset.getRemark(),
					asset.getUpdatedBy());
		}
		
		
		
		if (formDataNew) {
			jdbcTemplate.update(QueryConstants.INSERT_ASSET,
				asset.getAssetType(), asset.getAssetStatus(), asset.getSerialNo(), asset.getTag(),
				asset.getMake(), asset.getModel(), asset.getStoreCode(), asset.getOs(),
				asset.getMemory(), asset.getHardDisk(),
				asset.getPoNo(), asset.getPoDate(), asset.getInvoiceNo(), asset.getInvoiceDate(),
				asset.getRemark(), asset.getCreatedBy()
				
				,asset.getAssetType(), asset.getAssetStatus(), asset.getTag(),
				asset.getMake(), asset.getModel(), asset.getStoreCode(), asset.getOs(),
				asset.getMemory(), asset.getHardDisk(),
				asset.getPoNo(), asset.getPoDate(), asset.getInvoiceNo(), asset.getInvoiceDate(),
				asset.getRemark(), asset.getUpdatedBy());
		}
		
		List<String> filenames = asset.getAttachmentFileNames();
		
		if(!filenames.isEmpty()) {
			jdbcTemplate.batchUpdate(QueryConstants.INSERT_ATTACHMENT, new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, asset.getSerialNo());
					ps.setString(2, filenames.get(i));
				}

				public int getBatchSize() {
					return filenames.size();
				}

			});
		}
		
	}

	@Override
	public void create(List<Asset> assets) {
		this.jdbcTemplate.batchUpdate(
				QueryConstants.INSERT_ASSET_BATCH,
				new BatchPreparedStatementSetter() {
					//"insert into Asset"
					//		+ " (asset_type, asset_status, sr_no, tag, make, model, store_code, os, memory, hard_disk, po_no, po_date,"
					//		+ " invoice_no, invoice_date, remark, created_by)"
					//		+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Asset a = assets.get(i);
						
						ps.setString(1, a.getAssetType());
						ps.setString(2, a.getAssetStatus());
						ps.setString(3, a.getSerialNo());
						ps.setString(4, a.getTag());
						ps.setString(5, a.getMake());
						ps.setString(6, a.getModel());
						ps.setString(7, a.getStoreCode());
						ps.setString(8, a.getOs());
						ps.setString(9, a.getMemory());
						ps.setString(10, a.getHardDisk());
						ps.setString(11, a.getPoNo());
						ps.setObject(12, a.getPoDate());
						ps.setString(13, a.getInvoiceNo());
						ps.setObject(14, a.getInvoiceDate());
						ps.setString(15, a.getRemark());
						ps.setString(16, a.getCreatedBy());
					}

					public int getBatchSize() {
						return assets.size();
					}

				});
	}
	
	@Override
	public List<Asset> simpleSearch(String searchSql, Object[] params) {
		List<Asset> searchedAssets = jdbcTemplate.query(searchSql, params, new AssetMapper());
		return searchedAssets;
	}
	
	@Override
	public Integer getCount(String query, Object[] params) {
		return jdbcTemplate.queryForObject(query, params, Integer.class);
	}
	
	@Override
	public List<String> getAssetTypes() {
		return jdbcTemplate.queryForList("select name from asset_type", String.class);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<String> getAssetStatuses() {
		return jdbcTemplate.queryForList("select status from asset_status", String.class);
	}

	@Override
	public List<String> getDepartments() {
		return jdbcTemplate.queryForList("select name from department", String.class);
	}

	@Override
	public List<String> getAttachmentFilenames(String srNo) {
		String query = "select file_name from attachments where sr_no = '" + srNo +"'";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
	@Override
	public Map<String, List<String>> getAttachmentFilenames(List<String> srNos) {
		
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("srNos", srNos);
		List<Map<String, Object>> map = jdbcTemplate.queryForList("select sr_no, file_name from attachments where sr_no IN (:srNos) ", parameters);
		
		for (Map<String, Object> m : map ) {
			System.out.println(m.get(""));
		}
		
		return new HashMap<>();
	}

	@Override
	public List<Asset> getAudits(String serialNo) {
		List<Asset> searchedAssets = jdbcTemplate.query("select * from asset_audit where sr_no = '" + serialNo + "'", new AssetMapper());
		return searchedAssets;
	}
	
	@Override
	public List<String> getOs() {
		List<String> os = jdbcTemplate.queryForList("select os from os", String.class);
		return os;
	}

}
