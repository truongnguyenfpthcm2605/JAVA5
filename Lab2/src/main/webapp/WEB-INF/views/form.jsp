<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body >
	 <div style="width: 80%; margin: 0 auto;">
	 	<form action="/param/save/2021" method="post" style="text-align: center; width: 20%; margin: 0 auto;">
		<input type="text" name="y" value="2023">
		<button class="btn btn-success" >Save</button>
	</form>
	<hr>
	 <ul>
	 <li>${x }x</li>
	  <li>${y }y</li>
	 </ul>
	 </div>
</body>
</html>