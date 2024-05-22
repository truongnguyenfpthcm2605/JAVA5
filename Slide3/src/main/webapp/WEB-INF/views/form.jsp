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
		
				<form:form action="save" modelAttribute="staff" method="post">
						<form:input path="id"  placeholder="OK" />
						<form:input path="fullname"/>
						<form:input path="email"/>
						<form:input path="salary"/>
						<form:radiobutton path="gender" value="true" label="Male"/>
						<form:radiobutton path="gender" value="false" label="Female"/>
						<form:select path="postion">
								<form:option value="CEO">CEO</form:option>
								<form:option value="DIR">DIR</form:option>
								<form:option value="MAN">MAN</form:option>
								<form:option value="EMP">EMP</form:option>
						</form:select>
						<button>Save</button>
				</form:form>
		</div>
</body>
</html>