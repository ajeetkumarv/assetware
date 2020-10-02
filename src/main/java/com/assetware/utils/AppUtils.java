package com.assetware.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;

import org.springframework.util.DigestUtils;

import com.assetware.beans.Asset;

public class AppUtils {

	public static String strip(String data) {
		return data == null ? null : data.strip();
	}
	
	public static final boolean isBlank(String data) {
		return data == null || data.isBlank();
	}
	
	public static final String toString(LocalDateTime dateTime) {
		if (dateTime == null) {
			return "";
		}
		String date = dateTime.toString();
		try {
			date = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String checksum(Asset a) {
		
		StringJoiner sj = new StringJoiner("_");
		sj.add(a.getAssetType());
		sj.add(a.getAssetStatus());
		sj.add(a.getSerialNo());
		sj.add(a.getTag());
		sj.add(a.getMake());
		sj.add(a.getModel());
		sj.add(a.getStoreCode());
		sj.add(a.getMemory());
		sj.add(a.getHardDisk());
		sj.add(a.getOs());
		sj.add(a.getPoNo());
		sj.add(a.getPoDate() == null ? null : a.getPoDate().toString());
		sj.add(a.getInvoiceNo() == null ? null : a.getInvoiceNo());
		sj.add(a.getInvoiceDate() == null ? null : a.getInvoiceDate().toString());
		sj.add(a.getRemark());
		
	    return DigestUtils.md5DigestAsHex(sj.toString().getBytes()).toUpperCase();
	}
	
	public static final Map<String, String> fieldUINames = new HashMap<>();
	
	static {
		fieldUINames.put("serialNo", "SerialNo");
		fieldUINames.put("tag", "Tag");
		fieldUINames.put("assetType", "assetType");
		fieldUINames.put("assetStatus", "Asset Status");
		fieldUINames.put("make", "Make");
		fieldUINames.put("model", "Model");
		fieldUINames.put("storeCode", "Store Code");
		fieldUINames.put("memory", "Memory");
		fieldUINames.put("hardDisk", "Hard Disk");
		fieldUINames.put("os", "OS");
		fieldUINames.put("invoiceNo", "Invoice No");
		fieldUINames.put("invoiceDate", "Invoice Date");
		fieldUINames.put("poNo", "PO No");
		fieldUINames.put("poDate", "PO Date");
		fieldUINames.put("remark", "Remark");
	}
	
	public static String transformMemory(String input) {
		if (input == null || input.isBlank()) return input;
		
		Function<String, String> strip = (in) -> in.strip();
		Function<String, String> capitalize = (in) -> in.toUpperCase();
		Function<String, String> addSpace = (in) -> in.toUpperCase();
		//Function<String, String> capitalize = (in) -> in.toUpperCase();
		
		return null;
	}
}
