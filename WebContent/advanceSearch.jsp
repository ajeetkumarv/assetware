<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Advance Search</title>

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="./lib/bootstrap-select.min.css" />
<script src="./lib/bootstrap-select.min.js"></script>


<link rel="stylesheet" href="./lib/bootstrap-datepicker.standalone.min.css"/>
<script src="./lib/bootstrap-datepicker.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container">
		<p></p>
  		<h2>Advance Search</h2>
  		<p></p>
		<form action="./SearchAsset" method="get">
			<input type="text" hidden="hidden" name="searchType" value="advance">
			<div class="form-group row">
				<label for="assetType" class="col-sm-2 col-form-label">Asset Type</label>
				<div class="col-sm-4">
					<!-- <input type="text" id="assetType" name="assetType" class="form-control" > -->
					<select class="form-control selectpicker" id="assetType" name="assetType" title="Choose Asset Type">
						<c:forEach items="${assetTypes}" var="assetType">
							<option value="${assetType}">${assetType}</option>
						</c:forEach>
					</select>
				</div>
				<label for="assetStatus" class="col-sm-2 col-form-label">Asset Status</label>
				<div class="col-sm-4">
					<input type="text" id="assetStatus" name="assetStatus" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="serialNo" class="col-sm-2 col-form-label">Serial No.</label>
				<div class="col-sm-4">
					<input type="text" id="serialNo" name="serialNo" class="form-control">
				</div>
				<label for="location" class="col-sm-2 col-form-label">Location</label>
				<div class="col-sm-4">
					<input type="text" id="location" name="location" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="make" class="col-sm-2 col-form-label">Make</label>
				<div class="col-sm-4">
					<input type="text" id="make" name="make" class="form-control">
				</div>
				<label for="model" class="col-sm-2 col-form-label">Model</label>
				<div class="col-sm-4">
					<input type="text" id="model" name="model" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="storeCode" class="col-sm-2 col-form-label">Store Code</label>
				<div class="col-sm-4">
					<input type="text" id="storeCode" name="storeCode" class="form-control">
				</div>
				<label for="dept" class="col-sm-2 col-form-label">Department</label>
				<div class="col-sm-4">
					<input type="text" id="dept" name="dept" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="username" class="col-sm-2 col-form-label">User Name</label>
				<div class="col-sm-4">
					<input type="text" id="username" name="username" class="form-control">
				</div>
				<label for="empId" class="col-sm-2 col-form-label">Employee ID</label>
				<div class="col-sm-4">
					<input type="text" id="empId" name="empId" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="memory" class="col-sm-2 col-form-label">Memory</label>
				<div class="col-sm-4">
					<input type="text" id="memory" name="memory" class="form-control">
				</div>
				<label for="hardDisk" class="col-sm-2 col-form-label">Hard Disk</label>
				<div class="col-sm-4">
					<input type="text" id="hardDisk" name="hardDisk" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="poNo" class="col-sm-2 col-form-label">PO No.</label>
				<div class="col-sm-4">
					<input type="text" id="poNo" name="poNo" class="form-control">
				</div>
				<label for="poDate" class="col-sm-2 col-form-label">PO Date</label>
				<div class="col-sm-4">
					<input type="text" id="poDate" name="poDate" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="invoiceNo" class="col-sm-2 col-form-label">Invoice No.</label>
				<div class="col-sm-4">
					<input type="text" id="invoiceNo" name="invoiceNo" class="form-control">
				</div>
				<label for="invoiceDate" class="col-sm-2 col-form-label">Invoice Date</label>
				<div class="col-sm-4">
					<input type="text" id="invoiceDate" name="invoiceDate" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>


<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
 -->