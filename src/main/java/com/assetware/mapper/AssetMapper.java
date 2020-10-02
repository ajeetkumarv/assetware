package com.assetware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.assetware.beans.Asset;

public class AssetMapper implements RowMapper<Asset> {

	@Override
	public Asset mapRow(ResultSet rs, int rowNum) throws SQLException{
		Asset asset = new Asset();
		
		asset.setAssetStatus(rs.getString("asset_status"));
		asset.setAssetType(rs.getString("asset_type"));
		
		asset.setSerialNo(rs.getString("sr_no"));
		asset.setTag(rs.getString("tag"));
		
		asset.setMake(rs.getString("make"));
		asset.setModel(rs.getString("model"));
		
		asset.setStoreCode(rs.getString("store_code"));
		asset.setOs(rs.getString("os"));
		
		asset.setMemory(rs.getString("memory"));
		asset.setHardDisk(rs.getString("hard_disk"));
		
		asset.setInvoiceNo(rs.getString("invoice_no"));
		LocalDate invoiceDate = rs.getDate("invoice_date").toLocalDate();
		asset.setInvoiceDate(invoiceDate);
		
		asset.setPoNo(rs.getString("po_no"));
		
		LocalDate poDate = rs.getDate("po_date").toLocalDate();
		asset.setPoDate(poDate);
		
		asset.setRemark(rs.getString("remark"));
		
		asset.setCreatedBy(rs.getString("created_by"));
		asset.setUpdatedBy(rs.getString("updated_by"));
		
		LocalDateTime createdOn = rs.getTimestamp("created_on").toLocalDateTime();
		asset.setCreatedOn(createdOn);
		
		Timestamp timestamp = rs.getTimestamp("updated_on");
		
		if (timestamp != null) {
			LocalDateTime updatedOn = timestamp.toLocalDateTime();
			asset.setUpdatedOn(updatedOn);
		}
		return asset;
	}
	
}
