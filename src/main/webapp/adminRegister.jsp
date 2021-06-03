<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
div .form {
	margin-bottom: 50px;
}

label {
	display: inline-block;
	width: 250px;
	color: #000000;
}
</style>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<h3>Admin Registration</h3>
		<br><jsp:include page="message.jsp"></jsp:include><br>
		<form action="AdminRegisterServlet">
			<div class="form">
				<label for="name"><strong>Enter your Name:</strong></label> <input
					type="text" id="name" name="name" minlength="2" maxlength="20"
					required autofocus placeholder="Enter your name"> <br>
			</div>
			<div class="form">
				<label for="id"><strong>Enter your ID:</strong></label> <input
					type="text" id="id" name="id" required autofocus
					placeholder="Enter your ID"> <br>

			</div>
			<div class="form">
				<label for="pass"><strong>Enter Password:</strong></label> <input
					type="password" id="pass" name="pass" required autofocus
					placeholder="Enter Password"> <br>
			</div>
			<button class="btn btn-primary">Register</button>

			<button type="reset" class="btn btn-danger">Reset</button>

		</form>
	</main>
</body>
</html>