<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Stt</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quanity</th>
					<th scope="col">Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listCart}" varStatus="stt">
					<form action="/cart/update/${item.id}" method="post">
						<tr>
							<th>${stt.count }</th>
							<td>${item.name }</td>
							<td>${item.price } VND</td>
							<td><input type="number" name="qty" value="${item.qty}"
								onblur="this.form.submit()" style="width: 50px;"></td>
							<td>${item.price * item.qty } VND</td>
							<td><a href="/cart/delete/${item.id }" class="btn btn-danger"><i
									class='bx bxs-trash-alt'></i>Remove</a></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
		<p>Tổng tiền : ${total }</p>
		<a href="/cart/reset" class="btn btn-warning">
			<i class='bx bx-reset'></i>Clear Cart
		</a>
		<a href="/cart/view" class="btn btn-success">
			<i class='bx bx-cart-add'></i>Add More
		</a>
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