<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<b>${uri}</b>
<c:forEach var="item" items="${categories}">
	<li>${item.name}</li>
</c:forEach>