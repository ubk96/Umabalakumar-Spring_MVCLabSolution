<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Save Student</title>
</head>
<body>
	
	<div class="container">
		<h3>Student Directory</h3>
		<hr>
		
		<p class="h4 mb-4">Student</p>
		
		<form action="/StudentManagement/student/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name ="id" vlaue="${Student.id }" />
			
			<div class="form-inline">
			
				<input type="text" name="firstName" value="${Student.firstName }"
					class="form-control mb-4 col-4" placeholder="FirstName">
			
			</div>
			
			<div class="form-inline">
			
				<input type="text" name="lastName" value="${Student.lastName }"
					class="form-control mb-4 col-4" placeholder="LastName">
			
			</div>
			
			<div class="form-inline">
			
				<input type="text" name="department" value="${Student.department }"
					class="form-control mb-4 col-4" placeholder="Department">
			
			</div>
			
			<div class="form-inline">
			
				<input type="text" name="country" value="${Student.country }"
					class="form-control mb-4 col-4" placeholder="Country">
			
			</div>
		
			<button type="submit" class="btn btn-info col-2">Save</button>
			
		</form>
		
		<hr>
		<a href="StudentManagement/student/list">Back to Students list</a>
		
	</div>
</body>
</html>