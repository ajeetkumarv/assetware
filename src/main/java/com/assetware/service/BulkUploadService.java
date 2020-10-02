package com.assetware.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.assetware.beans.Asset;
import com.assetware.utils.AppUtils;
import com.assetware.utils.ServletUtils;

import static com.assetware.utils.AppUtils.strip;
//import com.opencsv.CSVReader;
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class BulkUploadService {
	//https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/
	public List<Asset> csvToBean(InputStream is) throws IOException {
		Reader reader = new BufferedReader(new InputStreamReader(is));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("serial no","asset tag","asset type","asset status","make","model","store code",
                		"po no", "po date", "invoice no", "invoice date","memory","hard disk","os")
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
		
		// Reading all records at once into memory
		//List<CSVRecord> csvRecords = csvParser.getRecords();
		
		List<Asset> assets = new ArrayList<>();
		
		for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
            Asset asset = parseCsvToAsset(csvRecord);
            assets.add(asset);
		}
		
		csvParser.close();
		
		return assets;
	}

	private Asset parseCsvToAsset(CSVRecord c) {
		String serialNo = c.get("serial no");
		String tag = c.get("asset tag");
		String assetType = c.get("asset type");
		String assetStatus = c.get("asset status");
		String make = c.get("make");
		String model = c.get("model");
		String memory = c.get("memory");
		String hardDisk = c.get("hard disk");
		String os = c.get("os");
		String storeCode = c.get("store code");
		String poNo = c.get("po no");
		String poDate = c.get("po date");
		String invNo = c.get("invoice no");
		String invDate = c.get("invoice date");
		
		Asset a = new Asset();
		
		a.setSerialNo(strip(serialNo));
		a.setTag(strip(tag));
		a.setAssetType(strip(assetType));
		a.setAssetStatus(strip(assetStatus));
		a.setMake(strip(make));
		a.setModel(strip(model));
		a.setMemory(strip(memory));
		a.setHardDisk(strip(hardDisk));
		a.setOs(strip(os));
		a.setStoreCode(strip(storeCode));
		a.setPoNo(strip(poNo));
		a.setPoDate(parseDate(poDate));
		a.setInvoiceNo(strip(invNo));
		a.setInvoiceDate(parseDate(invDate));
		
		return a;
	}
	
	LocalDate parseDate(String dateStr) {
		dateStr = AppUtils.strip(dateStr);
		
		if (AppUtils.isBlank(dateStr)) {
			return null;
		}
		
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
//	public List<Asset> csvToBean(InputStream is) {
//		//CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
//		CSVReader csvReader = new CSVReader(new InputStreamReader(is));
//		CsvToBean<Asset> csv = new CsvToBean<>();
//		csv.setCsvReader(csvReader);
//		csv.setMappingStrategy(strategy());
//		
//		List<Asset> list = csv.parse();
//		
//		return list;
//	}
//	
//	
//	private Map<String, String> mapFields() {
//		Map<String, String> mapping = new HashMap<>();
//        mapping.put("serial no", "serialNo");
//        mapping.put("asset type", "assetType");
//        mapping.put("asset status", "assetStatus");
//        mapping.put("asset tag", "tag");
//        mapping.put("make", "make");
//        mapping.put("model", "model");
//        mapping.put("store code", "storeCode");
//        mapping.put("memory", "memory");
//        mapping.put("hard disk", "hardDisk");
//        mapping.put("os", "os");
//        mapping.put("po no", "poNo");
//        mapping.put("po date", "poDate");
//        mapping.put("invoice no", "invoiceNo");
//        mapping.put("invoice date", "invoiceDate");
//        
//        return mapping;
//	}
//	
//	private HeaderColumnNameTranslateMappingStrategy<Asset> strategy() {
//		HeaderColumnNameTranslateMappingStrategy<Asset> strategy =
//				new HeaderColumnNameTranslateMappingStrategy<>();
//		strategy.setType(Asset.class);
//		strategy.setColumnMapping(mapFields());
//		
//		return strategy;
//	}
}
