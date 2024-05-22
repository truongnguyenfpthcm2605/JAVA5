<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>

<body>

	<div class="container" style="margin: 0 auto;">
		<h3>PAGE</h3>
		<form action="/view" method="post" class="row">
			<div class="col-md-8">
				<input type="text" name="keywords" class="form-control"
					value="${key}" placeholder="Nhập NameProduct">
			</div>

			<div class="col-md-4">
				<button class="btn btn-dark">Tìm Kiếm</button>
			</div>
		</form>
		<ul>
			<li >0</li>
			<li>${p.id }</li>
			<li>${p.name }</li>
			<li><fmt:formatNumber value="${p.price }" type="currency"
					currencyCode="VND" /></li>
			<li>${p.createdate }</li>
		</ul>
				<div style="margin-top: 10px">
					<table class="table">
						<thead>

							<tr>
								<th scope="col">STT</th>
								<th scope="col">ID</th>
								<th scope="col">NAME</th>
								<th scope="col">PRICE</th>
								<th scope="col">DATE</th>
							</tr>

						</thead>
						<tbody>

							<p>${message }</p>
							<c:forEach var="item" items="${list }" varStatus="index">
								<tr>
									<th scope="row">${index.count }</th>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td><fmt:formatNumber value="${item.price }"
											type="currency" currencyCode="VND" /></td>
									<td>${item.createdate }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>


				</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>
</html>