package com.assetware.dao.impl;

public class QueryConstants {


	
	public final static String INSERT_ASSET_AUDIT_TRIAL = "insert into asset_audit"
			+ " (asset_type, asset_status, sr_no, tag, make, model, store_code, os, memory, hard_disk, po_no, po_date,"
			+ " invoice_no, invoice_date, remark, created_by, created_on, updated_by)"
			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_ASSET= "insert into asset"
			+ " (asset_type, asset_status, sr_no, tag, make, model, store_code, os, memory, hard_disk, po_no, po_date,"
			+ " invoice_no, invoice_date, remark, created_by)"
			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
			+ " ON DUPLICATE KEY UPDATE "
			+ " asset_type=?, asset_status=?, tag=?, make=?, model=?, store_code=?, os=?, memory=?, hard_disk=?, po_no=?,"
			+ " po_date=?, invoice_no=?, invoice_date=?, remark=?, updated_by=?";
	
	public final static String INSERT_ASSET_BATCH = "insert into asset"
			+ " (asset_type, asset_status, sr_no, tag, make, model, store_code, os, memory, hard_disk, po_no, po_date,"
			+ " invoice_no, invoice_date, remark, created_by)"
			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_ATTACHMENT = "insert into attachments (sr_no, file_name) values (?, ?)";
	
	public final static String ASSET_HISTORY = "select * from (	"
			+ "select * from `asset` a where sr_no = ? "
			+ "union select * from `asset_audit` aa where sr_no = ? "
			+ ") a order by -updated_on";

	public static final String INSERT_USER = "insert into users"
			+ " (name, username, dept, designation, emp_id, contact_no, email, location, remark, created_by) values"
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			+ " ON DUPLICATE KEY UPDATE "
			+ " dept=?, designation=?, contact_no=?, email=?, location=?, remark=?";
	
	public static final String INSERT_ASSET_USER_MAP = "insert into asset_user_map"
			+ "(sr_no, emp_id, created_by) values (?, ?, ?)";
	
	public static final String DETACH_ASSET_USER_MAP = "update asset_user_map "
			+ " set end_dt = ?, updated_by = ?"
			+ " where sr_no = ? and emp_id = ? and end_dt is null";
	
	public static final String GET_ASSET_USER_DETAILS = "select emp_id, name, username, dept, designation, "
			+ " contact_no, email, location, remark, created_by, created_on from users"
			+ " where emp_id = (select emp_id from asset_user_map where sr_no = ? and end_dt is null)";
	
	public static final String GET_AWUSER = "select username, email from awuser where username = ? and password=?";

	public static final String GET_ASSET_USER_MAP = "select sr_no, emp_id, start_dt, end_dt, created_by, updated_by"
			+ " from asset_user_map where sr_no = ? order by -end_dt";
}
