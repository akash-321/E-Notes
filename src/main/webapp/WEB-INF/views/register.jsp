<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/WEB-INF/resource/components/all_link.jsp"%>
</head>
<body style="background-color: #CDFFFA;">
	<%@include file="/WEB-INF/resource/components/navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center">
						<h1>Register page</h1>
						<c:if test="${not empty msg }">
						<p class="fs-3 fw-bold text-success">${msg}</p>
						<c:remove var="msg"/>
						</c:if>
					</div>
					<div class="card-body">
						<form action="registeruser" method="post">
							<div class="md-3">
								<label> Enter  Full Name</label> <input type="text"
									name="fullname" class="form-control">
							</div>
							<div class="md-3">
								<label> Enter your Qualification</label> <input type="text"
									name="qualification" class="form-control">
							</div>
							<div class="md-3">	
								<label> Enter E-mail</label> <input type="email"
									name="email" class="form-control">
							</div>
							<div class="md-3">
								<label> Enter Password</label> <input type="password"
									name="password" class="form-control">
							</div>
							<button class="btn btn-primary col-md-12">Register</button>
						</form>
					</div>
					
				</div>
			</div>
		</div>

	</div>
	
</body>
</html>