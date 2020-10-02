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
		<p></p><h2>Search Result</h2>
		<p>
			<div class="dropdown">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
					Total Rows <span class="badge badge-light">${totalRows}</span>
				</button>
				<div class="dropdown-menu">
				    <a class="dropdown-item" href="./DownloadData?type=csv">Download csv</a>
				    <a class="dropdown-item" href="./DownloadData?type=excel">Download excel</a>
				</div>
				<c:forEach items="${searchCriteria}" var="criteria">
					<span class="badge badge-info">${criteria.key} = ${criteria.value}</span>
				</c:forEach>
			</div>
			
		</p>
		<input class="form-control" id="searchKeyword" type="text" placeholder="Search in this page..">
  		<br>
		<div class="table-responsive">
			<table class="table table-hover table-bordered table-sm" id="searchResultTable">
				<thead class="thead-light">
					<tr>
						<th nowrap>Sr No</th>
						<th nowrap>Tag</th>
						<th nowrap>Asset Type</th>
						<th nowrap>Asset Status</th>
						<th nowrap>Make</th>
						<th nowrap>Model</th>
						<th nowrap>Store Code</th>
						<th nowrap>OS</th>
						<th nowrap>PO No</th>
						<th nowrap>PO Date</th>
						<th nowrap>Invoice No</th>
						<th nowrap>Invoice Date</th>
						<th nowrap>Memory</th>
						<th nowrap>Hard disk</th>
						<th nowrap>Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${assets}" var="a">
						<tr>
							<td nowrap ><a href="./AssetLoader?srNo=${a.serialNo}">${a.serialNo}</a></td>
							<td nowrap>${a.tag}</td>
							<td nowrap>${a.assetType}</td>
							<td nowrap>${a.assetStatus}</td>
							<td nowrap>${a.make}</td>
							<td nowrap>${a.model}</td>
							<td nowrap>${a.storeCode}</td>
							<td nowrap>${a.os}</td>
							<td nowrap>${a.poNo}</td>
							<td nowrap>${a.poDate}</td>
							<td nowrap>${a.invoiceNo}</td>
							<td nowrap>${a.invoiceDate}</td>
							<td nowrap>${a.memory}</td>
							<td nowrap>${a.hardDisk}</td>
							<td nowrap><a data-toggle="modal" href="#myModal">View</a></td>
						</tr>		
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		
		<ul class="pagination justify-content-center">
		    <%--For displaying Previous link except for the 1st page --%>
		    <c:if test="${pageId != 1}">
		        <li class="page-item"><a class="page-link" href="./SearchAsset?pageId=${pageId-1}&records=${recordsAtTime}">Previous</a></li>
		    </c:if>
		    
		    <c:forEach begin="1" end="${totalPages}" var="i">
		    	
		    	<c:choose>
                    <c:when test="${pageId eq i}">
                        <li class="page-item active"><a class="page-link" href="./SearchAsset?pageId=${i}&records=${recordsAtTime}">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="./SearchAsset?pageId=${i}&records=${recordsAtTime}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
		    	
		    </c:forEach>
		    
		    <%--For displaying Next link --%>
		    <c:if test="${pageId lt totalPages}">
		        <li class="page-item"><a class="page-link" href="./SearchAsset?pageId=${pageId+1}&records=${recordsAtTime}">Next</a></li>
		    </c:if>
		</ul>
		
	</div>
	
	
	<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
	
	
	<script>
		$(document).ready(function(){
		  $("#searchKeyword").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#searchResultTable tbody tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	
</body>
</html>