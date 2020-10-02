<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" href="./lib/bootstrap.min.css" /> -->
<!-- <script src="lib/jquery.min.js"></script> -->
<!-- <script src="lib/popper.min.js"></script> -->
<!-- <script src="lib/bootstrap.min.js"></script> -->


<link rel="stylesheet" href="./lib/bootstrap-select.min.css" />
<script src="./lib/bootstrap-select.min.js"></script>


<link rel="stylesheet" href="./lib/bootstrap-datepicker.standalone.min.css"/>
<script src="./lib/bootstrap-datepicker.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container">
  		<h2>Create New User</h2>
		<form action="./CreateUser" method="post">
			<div class="form-group row">
				<label for="username" class="col-sm-2 col-form-label">Username</label>
				<div class="col-sm-4">
					<input type="text" id="username" name="username" class="form-control text-lowercase" required>
				</div>
				<label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
				<div class="col-sm-4">
					<input type="text" id="fullName" name="fullName" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email ID</label>
				<div class="col-sm-4">
					<input type="email" id="email" name="email" class="form-control text-lowercase" required>
				</div>
				<label for="contactNo" class="col-sm-2 col-form-label">Contact No</label>
				<div class="col-sm-4">
					<input type="text" id="contactNo" name="contactNo" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="dept" class="col-sm-2 col-form-label">Department</label>
				<div class="col-sm-4">
					<input type="text" id="dept" name="dept" class="form-control text-lowercase">
				</div>
				<label for="designation" class="col-sm-2 col-form-label">Designation</label>
				<div class="col-sm-4">
					<input type="text" id="designation" name="designation" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="empId" class="col-sm-2 col-form-label">Employee ID</label>
				<div class="col-sm-4">
					<input type="text" id="empId" name="empId" class="form-control text-lowercase" required>
				</div>
				<label for="location" class="col-sm-2 col-form-label">Location</label>
				<div class="col-sm-4">
					<input type="text" id="location" name="location" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label for="remark" class="col-sm-2 col-form-label">Remarks</label>
				<div class="col-sm-10">
					<textarea rows="4" class="form-control" id="remark" name="remark"></textarea>
				</div>
			</div>
			
			<!--  SUBMIT BUTTON BELOW -->
			
			<div class="form-group row">
				<div class="col-sm-2 offset-sm-2">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>
			</div>
		</form>
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
</script>

</body>
</html>


<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
 -->