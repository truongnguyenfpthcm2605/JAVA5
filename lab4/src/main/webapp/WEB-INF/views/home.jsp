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

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<style>
.card {
	width: 100%;
	padding: 10px;
	box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
	border-radius: 10px;
	margin-bottom: 10px;
}

.bxs-cart-alt{
	font-size: 100px;
}

.bxs-cart-alt:hover {
	color: brown;
	transform: scale(1.05);
	transition: all linear .5s;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h1>Shopping Online</h1>
			</div>
			<div class="col-md-2">
				<a href="/cart/viewcart"><i class='bx bxs-cart-alt'></i></a>
			</div>
		</div>
		<hr>
		<div class="container" style="width: 100%;">
			<div class="row">
				<c:forEach items="${list }" var="item">
					<div class="col-md-3 ">
						<div class="card ">
							<img src='<c:url value="/images/${item.img}"></c:url>' class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">${item.name }</h5>
								<p class="card-text">Apple Company</p>
								<h4>${item.price} VND</h4>
								<a href="/cart/add/${item.id }" class="btn btn-primary"><i class='bx bx-cart-add' ></i>Thêm </a>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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