<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<form:form action="valid" modelAttribute="staff3" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">ID</label> 
				<form:input path="id" class="form-control" />
				 <form:errors path="id" class="badge badge-danger" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Fullname</label> 
				<form:input path="fullname"  class="form-control" />
				 <form:errors path="fullname" class="badge badge-danger" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> 
				<form:input path="email"  class="form-control" />
				 <form:errors path="email" class="badge badge-danger" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Salary</label> 
				<form:input path="salary"  class="form-control" />
				 <form:errors path="salary" class="badge badge-danger" />
			</div>
			<div class="form-group">
				<form:radiobutton path="gender" value="true" label="Male" />
				<form:radiobutton path="gender" value="false" label="Female" /> <br>
				 <form:errors path="gender" class="badge badge-danger" />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Postion</label> 
				<form:input path="position"  class="form-control" />
				 <form:errors path="position" class="badge badge-danger" />
			</div>
			<div class="form-group">
					<form:checkboxes path="hobbies" items="${ hobbies}" delimiter="" /> <br>
					 <form:errors path="hobbies" class="badge badge-danger" />
			</div>
	
			<button class="btn btn-dark">Save</button>
		</form:form>
	</div>
</body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>