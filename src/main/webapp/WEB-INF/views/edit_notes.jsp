<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<h1>Edit Notes page</h1>
					</div>
					<div class="card-body">
						<form action="updateNotes" method="post">
							<div class="md-3">
								<label> Enter Title</label> <input type="text" name="title"
									class="form-control" value="${notes.title }">
							</div>
							<div class="md-3">
								<label> Enter descriptiom</label>
								<textarea row="5" cols="" class="form-control" name="description" >${notes.description }
								</textarea>
							</div>
							<input type="hidden" name="id" value="${notes.id}"> 
							<button class="btn btn-primary mt-5 ">Update</button>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>

</body>
</html>