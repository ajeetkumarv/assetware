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
		<%-- Welcome to Assetware --%>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<canvas id="myChart1"></canvas>
					<div class="card-body text-center">
						<p class="card-text">Asset status count</p>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<canvas id="myChart2"></canvas>
					<div class="card-body text-center">
						<p class="card-text">Asset purchase last 5 months</p>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	
	<script>
	//doughnut
var ctx = document.getElementById('myChart1').getContext('2d');
var ctx2 = document.getElementById('myChart2').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['New', 'In use', 'In repair', 'Disposed'],
        datasets: [{
            label: 'Asset statuses',
            data: [12, 19, 3, 5],
            backgroundColor: [
                'rgba(255, 99, 132, 0.7)',
                'rgba(0, 255, 0, 0.8)',
                'rgba(204, 51, 0, 0.8)',
                'rgba(0, 0, 102, 0.8)'
            ]
        }]
    }
});


var myChart = new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
</body>
</html>


<%-- <c:if test="${not empty msg}" >i
		<div class="alert alert-success alert-dismissible">
	  		<button type="button" class="close" data-dismiss="alert">&times;</button>
		  	${msg}
		</div>
		</c:if>  --%>