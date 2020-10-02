<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Assetware - Login</title>
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center">
  <h1>Assetware</h1>
  <p>Asset Management System</p>
</div>
  
<div class="container">
	<div class="form-group row">
		<div class="col-sm-4 offset-sm-4">
  			<h2>Login</h2>
  			<p>Enter your credentials</p>
  		</div>
  	</div>
  <form action="./Login" method="post">
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
      	<input type="text" class="form-control" id="usr" name="username" value="admin">
      </div>
    </div>
    <div class="form-group row">
      <label for="pwd" class="col-sm-4 offset-sm-4">Password</label>
      <div class="col-sm-4 offset-sm-4">
      	<input type="password" class="form-control" id="pwd" name="password" value="">
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