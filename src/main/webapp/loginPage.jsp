<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>Admin login</h2>
		<br>
		<form action="LoginServlet" method="post">
			<jsp:include page="message.jsp"></jsp:include>
			<label for="uname">Admin ID:</label> <input type="text" id="uname"
				name="uname" required="required" autofocus="autofocus"
				placeholder="Enter user name here"> <br> <br> <label
				for="pass">Access Key:</label> <input type="password" id="pass"
				name="pass" required="required" placeholder="Enter here"><br>
			<br>
			<button class="btn btn-primary">Enter</button>
		</form>
		Not yet Registered? <a href="adminRegister.jsp"> Click here to
			register</a>
	</main>
</body>
</html>