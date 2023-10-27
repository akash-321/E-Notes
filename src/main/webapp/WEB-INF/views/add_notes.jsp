<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD The Notes</title>
<%@include file="/WEB-INF/resource/components/all_link.jsp"%>
</head>
<body style="background-color: #CDFFFA;">
	<%@include file="/WEB-INF/resource/components/navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center">
						<h1>Add Notes page</h1>
						<c:if test="${not empty msg }">
							<p class="fs-3 fw-bold text-success">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="saveNotes" method="post">
							<div class="md-3">
								<label> Enter Title</label> <input type="text" name="title"
									class="form-control">
							</div>
							<div class="md-3">
								<label> Enter descriptiom</label>
								<textarea row="5" cols="" class="form-control" name="description">
								</textarea>
							</div>
							<button class="btn btn-primary mt-5 text-center">Save</button>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>

</body>
</html>