package com.assetware.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Asset {
	
	private String assetType;
	private String assetStatus;
	
	private String serialNo;
	private String tag;
	
	private String make;
	private String model;
	
	private String storeCode;
	//private String department;
	
	private String memory;
	private String hardDisk;
	private String os;
	
	private String poNo;
	private LocalDate poDate;
	
	private String invoiceNo;
	private LocalDate invoiceDate;
	
	private String remark;

	private String createdBy;
	private String updatedBy;
	
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	private List<String> attachmentFileNames;
	
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetStatus() {
		return assetStatus;
	}
	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
//	public String getDepartment() {
//		return department;
//	}
//	public void setDepartment(String department) {
//		this.department = department;
//	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public LocalDate getPoDate() {
		return poDate;
	}
	public void setPoDate(LocalDate poDate) {
		this.poDate = poDate;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public List<String> getAttachmentFileNames() {
		return attachmentFileNames;
	}
	public void setAttachmentFileNames(List<String> attachmentFileNames) {
		this.attachmentFileNames = attachmentFileNames;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	public String poDateFormatted() {
		if (poDate == null) {
			return "";
		}
		String date = poDate.toString();
		try {
			date = poDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public String invDateFormatted() {
		if (invoiceDate == null) {
			return "";
		}
		String date = invoiceDate.toString();
		try {
			date = invoiceDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
}
