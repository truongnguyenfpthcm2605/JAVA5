<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="controller">
		<h2 style="text-align: center;">Đăng Nhập</h2>
		<form action="/account/login" method="post" style="width: 50%; margin: 0 auto;">
				<label class="badge bg-secondary">Tên</label> 
				<input class="form-control" type="text" name="usersname" value="${username }" > <br>
				<label class="badge bg-secondary">Mật Khẩu</label>
				 <input class="form-control" type="password" name="password" value="${password }"> <br>
				<input type="checkbox" name="remember" value="true"> 
				<label class="badge bg-secondary"> Remember ?</label> <br>
				<hr>
				<button class="btn btn-dark" >Submit</button> <br>
				<h1 class="badge bg-secondary">${message }</h1> <br>
				<h2   class="badge badge-success">Hello : ${sessionScope.username}</h2>
		</form>
	</div>
</body>
</html>