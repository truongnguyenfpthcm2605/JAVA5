<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
		
				<form:form action="save" modelAttribute="staff2" method="post">
						<form:radiobuttons path="position" items="${ positions}" delimiter=""/>
						<form:checkboxes path="hobbies" items="${ hobbies}" delimiter="" />
						<form:select path="Country.id">
							<form:options items="${nationalities }" itemValue="id" itemLabel="name"></form:options>
						</form:select>
						<button>Save</button>
				</form:form>
		</div>
</body>
</html>