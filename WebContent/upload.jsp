<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Assets</title>

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
		<br>
		<br>
		<form action="./BulkUpload" method="post" enctype="multipart/form-data">
			<div>
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

						<div><br>
							<h4 class="text-center">
								Bulk upload assets
							</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<div class="col-sm-10 offset-sm-1">
								<input type="file" class="custom-file-input rounded-pill"
									id="files" name="files" multiple="multiple"> <label
									class="custom-file-label rounded-pill" for="files">Choose files</label>
								</div>
							</div>
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-primary">Upload</button>
						</div>
						<br>
					</div>
				</div>
			</div>
		</form>

		<c:if test="${not empty msg}" >
			<div class="alert alert-success alert-dismissible">
		  		<button type="button" class="close" data-dismiss="alert">&times;</button>
			  	${msg}
			</div>
		</c:if>
	</div>
	
	
	

<script>
// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  //var fileName = $(this).val().split("\\").pop();
  //$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  
  var fileNames = '';
  
  var input = document.getElementById('files');
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