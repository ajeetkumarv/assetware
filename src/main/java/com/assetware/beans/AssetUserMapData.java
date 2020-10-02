package com.assetware.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.assetware.utils.AppUtils;

public class AssetUserMapData {

	private String empId, serialNo;
	private String assignedBy, updatedBy;
	private LocalDateTime assignedOn, updatedOn;
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getAssignedOn() {
		return assignedOn;
	}
	public void setAssignedOn(LocalDateTime assignedOn) {
		this.assignedOn = assignedOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public String assingedDateFormatted() {
		return AppUtils.toString(assignedOn);
	}
	public String receivedDateFormatted() {
		return AppUtils.toString(updatedOn);
	}
}
