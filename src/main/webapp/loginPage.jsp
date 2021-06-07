<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.required
{
    color: red;
}
</style>
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
			<label for="uname">Admin ID:</label> <span class="required">*</span><br>
			<input type="text" id="uname"
				name="uname" required="required" autofocus="autofocus"
				placeholder="Enter your id"> <br><br>
				<label
				  for="pass">Access Key</label> <span class="required">*</span><br>
				<input type="password" id="pass"
				name="pass" required="required" placeholder="Enter access key"><br>
			
			<br>
			<button class="btn btn-primary">Enter</button>
			<button type="reset" class="btn btn-secondary">Reset</button><br><br>
		</form>
		Not yet Registered? <a href="adminRegister.jsp"> Click here to
			register</a>
	</main>
</body>
</html>