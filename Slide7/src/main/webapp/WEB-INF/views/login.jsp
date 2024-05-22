<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
		<form action="/account/login" method="post" style="width: 50%; margin: 0 auto;">
				<label class="badge bg-secondary">Tên</label> <input class="form-control" type="text" name="usersname"> <br>
				<label class="badge bg-secondary">Mật Khẩu</label> <input class="form-control" type="password" name="password" > <br>
			
				<button class="btn btn-dark" >Đăng Nhập</button> <br>
				<h1 class="badge bg-secondary">${error }${param.error}</h1>
		</form>
</body>
</html>