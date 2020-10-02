<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="./lib/bootstrap-select.min.css" />
<script src="./lib/bootstrap-select.min.js"></script>
<style>
    .bs-example{
        margin: 20px;        
    }
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container">
		<form>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="email" id="email" class="form-control">
			</div>
			<div class="form-group">
				<label for="pass">Password</label>
				<input class="form-control" id="pass" type="password">
			</div>
			<div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			</div>
			<div>
				<button type="button" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
	<div class="container">
		<div class="form-group row">
			<label for="email2" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" id="email2" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label for="pass2" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" id="pass2" class="form-control" >
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10 offset-sm-2">
				<label><input type="checkbox"> Remember Me</label>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10 offset-sm-2">
				<button type="button" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</div>
</body>
</html>