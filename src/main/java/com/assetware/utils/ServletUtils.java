package com.assetware.utils;

import static com.assetware.utils.AppUtils.isBlank;
import static com.assetware.utils.AppUtils.strip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.javatuples.Pair;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.assetware.beans.AWUser;
import com.assetware.beans.Asset;
import com.assetware.beans.User;

public class ServletUtils {
	
	public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static DataSource mysqlDataSource() {
		return mysqlDataSourceOnline();
	}
	
	public static DataSource mysqlDataSourceOnline() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://remotemysql.com:3306/ha0RuVYSG6");
        dataSource.setUsername("ha0RuVYSG6");
        dataSource.setPassword("JFwxS5Fu5m");
 
        return dataSource;
    }
	
	public static DataSource mysqlDataSourceLocal() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/assetware");
       // dataSource.setUsername("root");
       // dataSource.setPassword("Asset8419");
        dataSource.setUsername("admin");
        dataSource.setPassword("Ass3t@1234");
 
        return dataSource;
    }
	
	public static Pair<Asset, Map<String, String>> getAssetInfoFromRequest(HttpServletRequest request) {
		
		Map<String, String> searchFields = new HashMap<>();
		
		String srNo = findAndAddField("serialNo", request, searchFields);
		String tag = findAndAddField("tag", request, searchFields);
		String assetType = findAndAddField("assetType", request, searchFields);
		String assetStatus = findAndAddField("assetStatus", request, searchFields);
		String make = findAndAddField("make", request, searchFields);
		String model = findAndAddField("model", request, searchFields);
		String storeCode = findAndAddField("storeCode", request, searchFields);
		String memory = findAndAddField("memory", request, searchFields);
		String hardDisk = findAndAddField("hardDisk", request, searchFields);
		String os = findAndAddField("os", request, searchFields);
		//String dept = findAndAddField("dept");
		String invoiceNo = findAndAddField("invoiceNo", request, searchFields);
		String invoiceDate = findAndAddField("invoiceDate", request, searchFields);
		String poNo = findAndAddField("poNo", request, searchFields);
		String poDate = findAndAddField("poDate", request, searchFields);
		
		String remark = findAndAddField("remark", request, searchFields);
		
		Asset asset = new Asset();
		
		asset.setAssetStatus(strip(assetStatus));
		asset.setAssetType(strip(assetType));
		
		asset.setSerialNo(strip(srNo));
		asset.setTag(strip(tag));
		
		asset.setMake(strip(make));
		asset.setModel(strip(model));
		
		asset.setStoreCode(strip(storeCode));
		
		asset.setMemory(strip(memory));
		asset.setHardDisk(strip(hardDisk));
		asset.setOs(strip(os));
		
		asset.setInvoiceNo(strip(invoiceNo));
		asset.setPoNo(strip(poNo));
		
		if (!isBlank(strip(invoiceDate))) {
			asset.setInvoiceDate(LocalDate.parse(invoiceDate, DATE_FORMATTER));
		}
		
		if(!isBlank(strip(poDate))) {
			asset.setPoDate(LocalDate.parse(poDate, DATE_FORMATTER));
		}
		
		asset.setRemark(strip(remark));
		
		return Pair.with(asset, searchFields);
	}

	private static String findAndAddField(String field, HttpServletRequest request, Map<String, String> searchFields) {
		String data = request.getParameter(field);
		if (data != null && !"".equals(data.trim()))
			searchFields.put(AppUtils.fieldUINames.getOrDefault(field, field), data);
		
		return data;
	}
	
	/**
	 * This is to create new user
	 * @param request
	 * @return
	 */
	public static User getUserInfoFromRequest(HttpServletRequest request) {

		User user = new User();
		
		String name = request.getParameter("fullName");
		String username = request.getParameter("username");
		String contact = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String dept = request.getParameter("dept");
		String designation = request.getParameter("designation");
		String empId = request.getParameter("empId");
		String location = request.getParameter("location");
		String remark = request.getParameter("remark");
		
		user.setFullName(strip(name));
		user.setUsername(strip(username));
		user.setContactNo(strip(contact));
		user.setEmail(strip(email));
		user.setDept(strip(dept));
		user.setDesignation(strip(designation));
		user.setEmpId(strip(empId));
		user.setLocation(strip(location));
		user.setRemark(strip(remark));
		
		return user;
	}
	
	public static String getLoggedInUser(HttpServletRequest request) {
		HttpSession session =  request.getSession(false);
		AWUser loggedInUser = (AWUser) session.getAttribute("user");
		return loggedInUser.getUsername();
	}
}
