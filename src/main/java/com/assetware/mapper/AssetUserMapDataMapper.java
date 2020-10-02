package com.assetware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.assetware.beans.Asset;
import com.assetware.beans.AssetUserMapData;

public class AssetUserMapDataMapper implements RowMapper<AssetUserMapData> {

	@Override
	public AssetUserMapData mapRow(ResultSet rs, int rowNum) throws SQLException{
		AssetUserMapData assetUserMapData = new AssetUserMapData();
		
		assetUserMapData.setEmpId(rs.getString("emp_id"));
		assetUserMapData.setSerialNo(rs.getString("sr_no"));
		
		assetUserMapData.setAssignedBy(rs.getString("created_by"));
		assetUserMapData.setUpdatedBy(rs.getString("updated_by"));
		
		LocalDateTime assignedOn = rs.getTimestamp("start_dt").toLocalDateTime();
		assetUserMapData.setAssignedOn(assignedOn);
		
		Timestamp timestamp = rs.getTimestamp("end_dt");
		
		if (timestamp != null) {
			LocalDateTime updatedOn = timestamp.toLocalDateTime();
			assetUserMapData.setUpdatedOn(updatedOn);
		}
		
		return assetUserMapData;
	}
	
}
