<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<p>Hello</p>
			<c:forEach var="item" items="${filenames }">
						<img alt="" src="${pageContext.request.contextPath}/img/${item}">
			</c:forEach>
</body>
</html>