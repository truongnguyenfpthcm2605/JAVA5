<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div style="width: 40%; margin: 0 auto;">
		<form action="formProduct" method="post"
			style=" width: 100%; margin: 0 auto;">
			<div class="form-group">
				<label for="exampleInputEmail1">Tên Sản Phẩm</label> <input
					type="text" name="name"  class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> 
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1"> Giá Sản Phẩm</label> <input
					type="text" name="price" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email">
			</div>
			<button class="btn btn-success">Save</button>
		</form>
		<hr>
		<ul class="list-group">
			<li class="list-group-item">${name }</li>
			<li class="list-group-item">${price }</li>
		</ul>
	</div>
</body>
</html>