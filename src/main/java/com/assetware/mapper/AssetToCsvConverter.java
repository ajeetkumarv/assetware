package com.assetware.mapper;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.assetware.beans.Asset;
import com.assetware.utils.AppUtils;

public class AssetToCsvConverter {

	private static List<String> header;
	private List<Asset> assets;
	private Writer writer;
	
	static {
		header = Arrays.asList(new String[] {
				"serial no","asset tag","asset type","asset status",
				"make","model","store code","po no","po date",
				"invoice no","invoice date","memory","hard disk","os",
				
				"age","current user"
		});
	}
	
	public AssetToCsvConverter(List<Asset> assets, Writer writer) {
		this.assets = assets;
		this.writer = writer;
	}
	
	public void convert() throws IOException {
		
		CSVPrinter csvPrinter = getCsvPrinter();
        
        convertAssetToList(csvPrinter);

        csvPrinter.flush();
        writer.close();
        csvPrinter.close();
	}
	
	private void convertAssetToList(CSVPrinter csvPrinter) throws IOException {
		for (Asset a: assets) {
			Object[] vals = assetToArray(a);
        	csvPrinter.printRecord(vals);
        }
	}
	
	private Object[] assetToArray(Asset a) {
		Object[] vals = new Object[16];
		
		vals[header.indexOf("serial no")] = a.getSerialNo();
		vals[header.indexOf("asset tag")] = a.getTag();
		vals[header.indexOf("asset type")] = a.getAssetType();
		vals[header.indexOf("asset status")] = a.getAssetStatus();
		vals[header.indexOf("make")] = a.getMake();
		vals[header.indexOf("model")] = a.getModel();
		vals[header.indexOf("store code")] = a.getStoreCode();
		vals[header.indexOf("po no")] = a.getPoNo();
		vals[header.indexOf("po date")] = a.poDateFormatted();
		vals[header.indexOf("invoice no")] = a.getInvoiceNo();
		vals[header.indexOf("invoice date")] = a.invDateFormatted();
		vals[header.indexOf("memory")] = a.getMemory();
		vals[header.indexOf("hard disk")] = a.getHardDisk();
		vals[header.indexOf("os")] = a.getOs();
		
		vals[header.indexOf("age")] = null;
		vals[header.indexOf("current user")] = null;
		// when adding new element increase the array size
		
		return vals;
	}
	
	private CSVPrinter getCsvPrinter() throws IOException {
		String[] headerArr = new String[header.size()];
				
		headerArr = header.toArray(headerArr);
		
		return new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader(headerArr));
	}
	
	public List<String> getHeader() {
		return header;
	}
	
}
