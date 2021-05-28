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
		<h2>Login</h2>
		<br>
		<form action="LoginServlet">
			<label for="uname">Admin ID:</label> <input type="text" id="uname"
				name="uname" required="required" autofocus="autofocus"
				placeholder="Enter user name here"> <br> <em>Default
				User Name : admin</em> <br> <br> <label for="pass">Access
				Key:</label> <input type="password" id="pass" name="pass"
				required="required" placeholder="Enter here"><br> <em>Default
				Access Key: admin!</em><br> <br>
			<button class="btn btn-secondary">Enter</button>

		</form>
	</main>
</body>
</html>