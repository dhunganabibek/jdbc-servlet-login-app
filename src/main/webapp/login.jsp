<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body class="container">

	<h1 class="text-center pt-4">Login Form</h1>

	<form class="mx-auto" style="width: 50%" action="login" method="post">
		<div class="form-group">
			<label for="email">Email</label> <input type="text" name="email"
				id="email" placeholder="Enter your email" class="form-control" />
		</div>

		<div class="form-group mb-3">
			<label for="password">Password</label> <input type="password"
				name="password" id="password" placeholder="Enter your password"
				class="form-control" />
		</div>

		<button type="submit" class="btn btn-success" style="width: 20%">Login</button>


		<h3 class="text-center">${message}</h3>





	</form>

</body>
</html>