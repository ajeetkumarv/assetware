<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.assetware.beans.AWUser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Assetware</title>

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
	<script src="./lib/Chart.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<p>
	<p>
	
	<div class="container">
		<div class="form-group row">
			<div class="col-sm-4 offset-sm-4">
	  			<h2>Change password</h2>
	  		</div>
	  	</div>
	  <form action="./ChangePassword" method="post">
	  	<div class="form-group row">
	  		<div class="col-sm-4 offset-sm-4">
	    			<c:if test="${not empty param.msg and param.msg == 'failed'}">
							<div class="alert alert-danger alert-dismissible fade show">
							    <button type="button" class="close" data-dismiss="alert">&times;</button>
							    <strong>Error!</strong> Username password incorrect
							  </div>
					</c:if>
	    	</div>
	  	</div>
	    <div class="form-group row">
	      <label for="usr" class="col-sm-4 offset-sm-4">Username</label>
	      <div class="col-sm-4 offset-sm-4">
	      	<%
  			com.assetware.beans.AWUser usr = (com.assetware.beans.AWUser) session.getAttribute("user");
  			if (usr!= null) {
  			%>
	      		<input type="text" disabled class="form-control" id="usr" name="username" value="<%=usr.getUsername()%>">
	      	<%
  			}
	      	%>
	      </div>
	    </div>
	    <div class="form-group row">
	      <label for="pwd" class="col-sm-4 offset-sm-4">Current Password</label>
	      <div class="col-sm-4 offset-sm-4">
	      	<input type="password" class="form-control" id="pwd" name="password" value="">
	      </div>
	    </div>
	    
	    <div class="form-group row">
	      <label for="newPass" class="col-sm-4 offset-sm-4">New Password</label>
	      <div class="col-sm-4 offset-sm-4">
	      	<input type="password" class="form-control" id="newPass" name="newPass" value="">
	      </div>
	    </div><div class="form-group row">
	      <label for="repeatNewPass" class="col-sm-4 offset-sm-4">Repeat New Password</label>
	      <div class="col-sm-4 offset-sm-4">
	      	<input type="password" class="form-control" id="repeatNewPass" name="repeatNewPass" value="">
	      </div>
	    </div>
	    <div class="form-group row">
	    	<div class="col-sm-1 offset-sm-4">
	    		<button type="submit" class="btn btn-primary">Submit</button>
	    	</div>
	    </div>
	  </form>
	</div>

</body>
</html>


<%-- <c:if test="${not empty msg}" >i
		<div class="alert alert-success alert-dismissible">
	  		<button type="button" class="close" data-dismiss="alert">&times;</button>
		  	${msg}
		</div>
		</c:if>  --%>