<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asset Details</title>

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

	<div class="container"><br>
  		<h2>Asset Details</h2>
  		<br>
		<form action="./SaveAsset" method="post" enctype="multipart/form-data">

			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item"><a class="nav-link active"	data-toggle="tab" href="#home">Details</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#purchase">Purchase Details</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#config">Configuration</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#attach">Attachments</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#changeHis">Change History</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#userHis">User History</a></li>
			</ul>

			<!-- Tab panes -->
		  <div class="tab-content">
		    <div id="home" class="container tab-pane active">
		    	<br>
		    	<input type="text" hidden value="${assetHash}" name="assetHash" id="assetHash">
		    	<div class="form-group row">
					<label for="serialNo" class="col-sm-2 col-form-label">Serial No.</label>
					<div class="col-sm-4">
						<input type="text" id="serialNo" name="serialNo" class="form-control" value="${a.serialNo}" required="required">
					</div>
					<label for="tag" class="col-sm-2 col-form-label">Tag</label>
					<div class="col-sm-4">
						<input type="text" id="tag" name="tag" class="form-control text-capitalize" value="${a.tag}">
					</div>
				</div>
		    	
		    	<div class="form-group row">
					<label for="assetType" class="col-sm-2 col-form-label">Asset Type</label>
					<div class="col-sm-4">
						<select class="form-control selectpicker" id="assetType" name="assetType" title="Choose Asset Type">
							<c:forEach items="${assetTypes}" var="assetType">
								<option value="${assetType}" ${assetType==a.assetType ? 'selected="selected"':'' }>${assetType}</option>
							</c:forEach>
						</select>
					</div>
					<label for="assetStatus" class="col-sm-2 col-form-label">Asset Status</label>
					<div class="col-sm-4">
						<select class="form-control selectpicker" id="assetStatus" name="assetStatus" title="Choose Asset Status">
							<c:forEach items="${assetStatuses}" var="assetStatus">
								<option value="${assetStatus}" ${assetStatus==a.assetStatus ? 'selected="selected"':'' }>${assetStatus}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			
			<div class="form-group row">
				<label for="make" class="col-sm-2 col-form-label">Make</label>
				<div class="col-sm-4">
					<input type="text" id="make" name="make" class="form-control" value="${a.make}">
				</div>
				<label for="model" class="col-sm-2 col-form-label">Model</label>
				<div class="col-sm-4">
					<input type="text" id="model" name="model" class="form-control" value="${a.model}">
				</div>
			</div>
			<div class="form-group row">
				<label for="storeCode" class="col-sm-2 col-form-label">Store Code</label>
				<div class="col-sm-4">
					<input type="text" id="storeCode" name="storeCode" class="form-control text-uppercase" value="${a.storeCode}">
				</div>
				<%-- <label for="dept" class="col-sm-2 col-form-label">Department</label>
				<div class="col-sm-4">
					<select class="form-control selectpicker" id="dept" name="dept" title="Choose Asset Status">
						<c:forEach items="${departments}" var="department">
							<option value="${department}">${department}</option>
						</c:forEach>
					</select>
				</div> --%>
			</div>
			
			<div class="form-group row">
				<label for="remark" class="col-sm-2 col-form-label">Remarks</label>
				<div class="col-sm-10">
					<textarea rows="4" class="form-control" id="remark" name="remark">${a.remark}</textarea>
				</div>
			</div>
		    
		    </div>
		    <div id="purchase" class="container tab-pane fade">
		      <br>
		      
		      <div class="form-group row">
				<label for="poNo" class="col-sm-2 col-form-label">PO No.</label>
				<div class="col-sm-4">
					<input type="text" id="poNo" name="poNo" class="form-control" value="${a.poNo}">
				</div>
				<label for="poDate" class="col-sm-2 col-form-label">PO Date</label>
				<div class="col-sm-4">
					<%-- <input type="text" id="poDate" name="poDate" class="form-control" value="${a.poDate}"> --%>
					<input type="text" id="poDate" name="poDate" class="form-control datepicker" data-date-format="dd-mm-yyyy" data-provide="datepicker" value="${a.poDateFormatted()}" placeholder="dd-mm-yyyy">
				</div>
			</div>
			<div class="form-group row">
				<label for="invoiceNo" class="col-sm-2 col-form-label">Invoice No.</label>
				<div class="col-sm-4">
					<input type="text" id="invoiceNo" name="invoiceNo" class="form-control" value="${a.invoiceNo}">
				</div>
				<label for="invoiceDate" class="col-sm-2 col-form-label">Invoice Date</label>
				<div class="col-sm-4">
					<%-- <input type="text" id="invoiceDate" name="invoiceDate" class="form-control" value="${a.invoiceDate}"> --%>
					<input type="text" id="invoiceDate" name="invoiceDate" class="form-control datepicker" data-date-format="dd-mm-yyyy" data-provide="datepicker" value="${a.invDateFormatted()}" placeholder="dd-mm-yyyy">
				</div>
			</div>
		      
		    </div>
		    <div id="config" class="container tab-pane fade">
		      <br>
		      <div class="form-group row">
				<label for="memory" class="col-sm-2 col-form-label">Memory</label>
				<div class="col-sm-4">
					<input type="text" id="memory" name="memory" class="form-control" value="${a.memory}">
				</div>
				<label for="hardDisk" class="col-sm-2 col-form-label">Hard Disk</label>
				<div class="col-sm-4">
					<input type="text" id="hardDisk" name="hardDisk" class="form-control" value="${a.hardDisk}">
				</div>
			</div>
			<div class="form-group row">
				<label for="os" class="col-sm-2 col-form-label">Operating System</label>
				<div class="col-sm-4">
					<!-- <input type="text" id="os" name="os" class="form-control"> -->
					<select class="form-control selectpicker" id="os" name="os" title="Choose OS">
						<c:forEach items="${os}" var="o">
							<option value="${o}" ${o==a.os? 'selected="selected"':'' }>${o}</option>
						</c:forEach>
					</select>
				</div>
				</div>
		    </div>
		    <div id="attach" class="container tab-pane fade">
		      <br>
		      <div class="form-group">
		      	<ul>
					<c:forEach items="${a.attachmentFileNames}" var="af">
						<li><a href="./FetchImage?sr=${a.serialNo}&file=${af}" target="_blank">${af}</a></li>
					</c:forEach>
					<c:if test="${empty a.attachmentFileNames}">
						<li>No attachments</li>
					</c:if>
				</ul>
		      </div>
		      <div class="form-group">
				<label class="col-sm-2 col-form-label">Attach new files</label>
				<div class="col-sm-9 custom-file">
      				<input type="file" class="custom-file-input" id="customFile" name="filename" multiple="multiple">
      				<label class="custom-file-label" for="customFile">Choose file</label>
    			</div>
			</div>
		      
		    </div>
		    <div id="changeHis" class="container tab-pane"><br>
		      <div id="historyAccordion">
		      <c:forEach items="${changeData}" var="cd">
		      			<div class="card">
						      <a class="collapsed card-link" data-toggle="collapse" href="#${cd.getId()}">
						    <div class="card-header">
						        ${cd.by} on ${cd.on}
						    </div>
						      </a>
						    <div id="${cd.getId()}" class="collapse" data-parent="#historyAccordion">
						      <div class="card-body">
						      <table class="table table-borderless">
									    <thead>
									      <tr>
									        <th>Field</th>
									        <th>From</th>
									        <th>To</th>
									      </tr>
									    </thead>
									    <tbody>
						        <c:forEach items="${cd.changes}" var="d">
									      <tr>
									        <td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${d.getValue0()}</td>
									        <td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${d.getValue1()}</td>
									        <td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${d.getValue2()}</td>
									      </tr>
						      	</c:forEach>
						      	</tbody>
								</table>
						      </div>
						    </div>
					  </div>
		      		
		      </c:forEach>
		      </div>
		    </div>
		    
		     <div id="userHis" class="container tab-pane"><br>
					<table class="table table-borderless">
						<thead>
							<tr>
								<th>Emp id</th>
								<th>Assigned by</th>
								<th>Assigned on</th>
								<th>Received by</th>
								<th>Received on</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userHis}" var="uh">
								<tr>
									<td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${uh.empId}</td>
									<td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${uh.assignedBy}</td>
									<td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${uh.assingedDateFormatted()}</td>
									<td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${uh.updatedBy}</td>
									<td class="mt-sm-0 mb-sm-0 pt-sm-0 pb-sm-0">${uh.receivedDateFormatted()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		    
		  </div>


			
			<!--  SUBMIT BUTTON BELOW -->
			<hr>
			
			<ul class="nav nav-pills">
			  <li class="nav-item">
			    <button type="submit" class="btn btn-primary">Save</button>
			  </li>
			  <li class="nav-item">
			    <button type="button" class="btn btn-outline-primary ml-sm-2" data-toggle="modal" data-target="#attachUser" id="attachUserBtn" ${serialNo == '' ? 'disabled' : '' }>Attach User</button>
			  </li>
			  <li class="nav-item">
			    <button type="button" class="btn btn-outline-primary ml-sm-2" data-toggle="modal" data-target="#currUser">Current User</button>
			  </li>
			</ul>
			
			
		</form>
	</div> <!--  div container ends here -->
	
	<!-- The Modal -->
			<div class="modal" id="attachUser">
			  <div class="modal-dialog  modal-dialog-scrollable">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">Attach User</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			      	<input type="text" name="srNo1" id="srNo1" hidden>
			      	<div class="form-group row">
						<label for="empId" class="col-sm-4 col-form-label">Employee ID</label>
						<div class="col-sm-8">
							<input type="text" id="empId" name="empId" class="form-control" required>
						</div>
					</div>
			        <div class="form-group row">
						<label for="username" class="col-sm-4 col-form-label">Username</label>
						<div class="col-sm-8">
							<input type="text" id="username" name="username" class="form-control text-lowercase">
						</div>
					</div>
					<div class="form-group row">
						<label for="fullName" class="col-sm-4 col-form-label">Full Name</label>
						<div class="col-sm-8">
							<input type="text" id="fullName" name="fullName" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-4 col-form-label">Email ID</label>
						<div class="col-sm-8">
							<input type="email" id="email" name="email" class="form-control text-lowercase">
						</div>
					</div>
					<div class="form-group row">
						<label for="contactNo" class="col-sm-4 col-form-label">Contact No</label>
						<div class="col-sm-8">
							<input type="text" id="contactNo" name="contactNo" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="dept" class="col-sm-4 col-form-label">Department</label>
						<div class="col-sm-8">
							<input type="text" id="dept" name="dept" class="form-control text-lowercase">
						</div>
					</div>
					<div class="form-group row">
						<label for="designation" class="col-sm-4 col-form-label">Designation</label>
						<div class="col-sm-8">
							<input type="text" id="designation" name="designation" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="location" class="col-sm-4 col-form-label">Location</label>
						<div class="col-sm-8">
							<input type="text" id="location" name="location" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="mapUserRemark" class="col-sm-4 col-form-label">Remarks</label>
						<div class="col-sm-8">
							<textarea rows="4" class="form-control" id="mapUserRemark" name="mapUserRemark"></textarea>
						</div>
					</div>
					
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button id="attachBtn" type="button" class="btn btn-primary" data-dismiss="modal">Attach</button>
			        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
			      </div>
			
			    </div>
			  </div>
			</div>
			
			<!-- The Modal -->
			<div class="modal" id="currUser">
			  <div class="modal-dialog modal-dialog-scrollable">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">Asset User Details</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body ">
			      	<input type="text" name="srNo2" id="srNo2" hidden>
			        <div class="form-group row">
						<label for="empId2" class="col-sm-4 col-form-label">Employee ID</label>
						<div class="col-sm-8">
							<input type="text" id="empId2" name="empId2" class="form-control" required>
						</div>
					</div>
			        <div class="form-group row">
						<label for="username2" class="col-sm-4 col-form-label">Username</label>
						<div class="col-sm-8">
							<input type="text" id="username2" name="username2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="fullName2" class="col-sm-4 col-form-label">Full Name</label>
						<div class="col-sm-8">
							<input type="text" id="fullName2" name="fullName2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="email2" class="col-sm-4 col-form-label">Email ID</label>
						<div class="col-sm-8">
							<input type="email" id="email2" name="email2" class="form-control text-lowercase">
						</div>
					</div>
					<div class="form-group row">
						<label for="contactNo2" class="col-sm-4 col-form-label">Contact No</label>
						<div class="col-sm-8">
							<input type="text" id="contactNo2" name="contactNo2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="dept2" class="col-sm-4 col-form-label">Department</label>
						<div class="col-sm-8">
							<input type="text" id="dept2" name="dept2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="designation2" class="col-sm-4 col-form-label">Designation</label>
						<div class="col-sm-8">
							<input type="text" id="designation2" name="designation2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="location2" class="col-sm-4 col-form-label">Location</label>
						<div class="col-sm-8">
							<input type="text" id="location2" name="location2" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="mapUserRemark2" class="col-sm-4 col-form-label">Remarks</label>
						<div class="col-sm-8">
							<textarea rows="4" class="form-control" id="mapUserRemark2" name="mapUserRemark2"></textarea>
						</div>
					</div>
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			      	<button type="button" class="btn btn-outline-danger" data-dismiss="modal" id="detachBtn">Detach User</button>
			      	<button type="button" class="btn btn-outline-primary" data-dismiss="modal">Update</button>
			        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			      </div>
			
			    </div>
			  </div>
			</div>
			
	<div id="someDiv">
	</div>
	

<script>
// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  //var fileName = $(this).val().split("\\").pop();
  //$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  
  var fileNames = '';
  
  var input = document.getElementById('customFile');
  for (var i = 0; i < input.files.length; ++i) {
	    fileNames += input.files.item(i).name + ', ';
	}
  $(this).siblings(".custom-file-label").addClass("selected").html(fileNames.slice(0, -2));
  //console.log(input.files.item(0).name + ' is first file');
  //console.log(input.files.item(1).name + ' is second file');
  
});

$('.datepicker').datepicker({
    format: "dd-mm-yyyy",
    autoclose: true,
    clearBtn: true,
    todayHighlight: true
}).on('changeDate', function (ev) {
    $(this).datepicker('hide');
});

$(document).ready(function(){
    $("#serialNo").on("change", function(){
    	//alert('test1' + $(this).val())
    	 var s = $(this).val();
    	if(s.trim()) {
    		$("#attachUserBtn").prop('disabled', false);
    	} else {
    		$("#attachUserBtn").prop('disabled', true);
    	}
    	
        //$("#srNo1").val($(this).val());
        //$("#srNo2").val($(this).val());
    });
});

// AJAX Call //////////////////////////

$(document).ready(function() {
         $("#attachBtn").click(function() { // modal attach button
        	 var emptest = $("#empId").val();
        	 var srtest = $("#serialNo").val();
        	 if (!emptest.trim()) {
        		 alert("Employee Id is required");
        		 return;
        	 }
        	 
        	 if (!srtest.trim()) {
        		 alert("Serial no is required");
        		 return;
        	 }
             servletCallToAttach();
         });

     });
     function servletCallToAttach() {
         $.post(
             "MapAssetUser", 
             {
            	 srNo : $("#serialNo").val(),
            	 empId : $("#empId").val(),
            	 username: $("#username").val(),
            	 email: $("#email").val(),
            	 contactNo: $("#contactNo").val(),
            	 dept: $("#dept").val(),
            	 location: $("#location").val(),
            	 remark: $("#mapUserRemark").val(),
            	 fullName: $("#fullName").val(),
            	 designation: $("#designation").val()
             },
             function(result, status) {
             	alert('Saved successfully ' + result);
         }).fail(function(jqxhr, settings, ex) { alert('failed, ' + jqxhr.responseText); });
     };

     $(document).ready(function() {
         $("#detachBtn").click(function() {
        	 var emp2test = $("#empId2").val();
        	 var sertest = $("#serialNo").val();
        	 if (!emp2test.trim()) {
        		 alert("Employee Id is required");
        		 return;
        	 }
        	 
        	 if (!sertest.trim()) {
        		 alert("Serial no is required");
        		 return;
        	 }
        	 
	       	servletCallToDetach();
        	 
         });

     });
     function servletCallToDetach() {
         $.post(
             "DetachAssetUser", 
             {
            	 srNo : $("#serialNo").val(),
            	 empId : $("#empId2").val()
             },
             function(result, status) {
             	alert('Saved successfully ' + result);
         }).fail(function(jqxhr, settings, ex) { alert('failed, ' + jqxhr.responseText); });
     };
     
     $(document).ready(function () {
    	    $('#currUser').on('shown.bs.modal', function() {
    	    	
    	    	if( !$('#serialNo').val().trim()) {
    	    		alert('Serial no empty');
    	    		return;
    	    	}
    	       fetchAndSetUserDetails();
    	    });
    	 });
     
      function fetchAndSetUserDetails() {
    	 var url = "AssetUserSearch?serialNo=" + $("#serialNo").val();
    	 $.get(url, 
    		function(data, status){
    		 
    		 	console.log('Data received: ' + data);
    		    $('#empId2').val(data.empId);
    		    $('#username2').val(data.username);
    		    $('#email2').val(data.email);
    		    $('#contactNo2').val(data.contactNo);
    		    $('#fullName2').val(data.fullName);
    		    $('#dept2').val(data.dept);
    		    $('#designation2').val(data.designation);
    		    $('#mapUserRemark2').val(data.remark);
    		    $('#location2').val(data.location);
    		});
     }
     
</script>

</body>
</html>


<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
 -->