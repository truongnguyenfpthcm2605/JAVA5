<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

	<div class="controller" style="width: 60%; margin: 0 auto;">
			<form:form action="/student/save" modelAttribute="sv" method="post">
		<div class="form-group">
			<label for="">Name</label>
			<form:input path="name" class="form-control" />	
			<form:errors path="name" style="color:red" />
		</div>
		<div class="form-group">
			<label for="">Email</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" style="color:red" />
		</div>
		<div class="form-group">
			<label for="">Marks</label>
			<form:input path="marks" class="form-control" />
			<form:errors path="marks" style="color:red" />
		</div>
		<div class="form-group">
			<label for="">Gender</label> <br>
			<form:radiobuttons items="${genders}" path="gender"/> <br>
			<form:errors path="gender" style="color:red" />
		</div>
		<div class="form-group">
			<label for="">Hobbies</label> <br>
			<form:checkboxes items="${hobbies}" path="hobbies"/> <br>
			<form:errors path="hobbies" style="color:red" />
		</div>
		
		<form:select path="faculty" class="form-control">
				<c:forEach items="${faculties }" var="item">
						<form:option value="${item }"></form:option>
				</c:forEach>
		</form:select>
		<form:errors path="faculty" style="color:red" />
		<hr>
		<button class="btn btn-dark">Save</button>
	</form:form>
	<p>${message }</p>
	</div>
</body>
</html>