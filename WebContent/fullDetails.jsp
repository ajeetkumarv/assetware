<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assetware - Search Result</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="./lib/bootstrap-select.min.css" />
<script src="./lib/bootstrap-select.min.js"></script>

</head>
<body>
	<%@include file="header.jsp"%>
	
	<div class="container"> 		
		
		<c:forEach items="${assets}" var="a">
		<p></p>
			<h4>Serial Id: ${a.serialNo}</h4>
			<div class="row">
			<div class="col-sm-6">
				<label class="col-sm-6">Serial No</label><input type="text" value="${a.serialNo}" disabled>
				<label class="col-sm-6">Tag</label><input type="text" value="${a.tag}" disabled>
				<label class="col-sm-6">Store Code</label><input type="text" value="${a.storeCode}" disabled>
				<label class="col-sm-6">OS</label><input type="text" value="${a.os}" disabled>
				
				<label class="col-sm-6">Asset Type</label><input type="text" value="${a.assetType}" disabled>
				<label class="col-sm-6">Asset Status</label><input type="text" value="${a.assetStatus}" disabled>
				<label class="col-sm-6">Make / Model</label><input type="text" value="${a.make} / ${a.model}" disabled>
				<label class="col-sm-6">Memory / Hard disk</label><input type="text" value="${a.memory} / ${a.hardDisk}" disabled>
				
				<label class="col-sm-6">PO No / PO Date</label><input type="text" value="${a.poNo} / ${a.poDate}" disabled>
				<label class="col-sm-6">Invoice No / Invoice Date</label><input type="text" value="${a.invoiceNo} / ${a.invoiceDate}" disabled>
				
			</div>
			<div class="col-sm-6">
				<h5>Remarks</h5>
				<textarea class="col-sm-12" rows="5" >${a.remark}</textarea>
				<p></p>
				<h5>Attachments</h5>
				<ul>
					<c:forEach items="${a.attachmentFileNames}" var="af">
						<li><a href="./FetchImage?sr=${a.serialNo}&file=${af}">${af}</a></li>
					</c:forEach>
					<c:if test="${empty a.attachmentFileNames}">
						<li>No attachments</li>
					</c:if>
				</ul>
				<p></p>
				<h5>History Timelines</h5>
				<p>Created by: ${a.createdBy} on ${a.createdOn}</p>
				
				<c:forEach items="${assetAudits}" var="aud">
					<p>Updated by: ${aud.updatedBy} on ${aud.updatedOn}</p>
				</c:forEach>
				
			</div>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>