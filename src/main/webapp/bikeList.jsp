<%@page import="in.dilshad.model.BikeSpecification"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>

<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>


<%@page import="in.dilshad.service.BikeManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid;
}

tr:hover {
	background-color: #f5f5f5;
}
</style>
<meta charset="ISO-8859-1">
<title>Available bikes</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


		<br> <br>
		<h4>List of Available bikes</h4>

		<%
		List<BikeSpecification> bikeList = (List<BikeSpecification>) request.getAttribute("BIKE_LIST");
		if (bikeList == null) {
			out.print("No records found");
		} else {
		%>
		<table>
			<caption>List of Bikes</caption>

			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Manufacturer</th>
					<th scope="col">Model</th>
					<th scope="col">Color</th>
					<th scope="col">Fuel</th>
					<th scope="col">Year</th>
					<th scope="col">Plate no.</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 1;
				for (BikeSpecification bike : bikeList) {
					out.print("<tr>");
					out.print("<td>" + i + "</td>");
					out.print("<td>" + bike.getBikeManufacturer() + "</td>");
					out.print("<td>" + bike.getBikeModel() + "</td>");
					out.print("<td>" + bike.getBikeColor() + "</td>");
					out.print("<td>" + bike.getEngineDetails().get("fuelType") + "</td>");
					out.print("<td>" + bike.getManufactureYear() + "</td>");
					out.print("<td>" + bike.getEngineDetails().get("noPlate") + "</td>");
					out.print("<td>" + "Rs." + bike.getBikePrice() + "</td>");
					out.print("</tr>");
					i++;
				}
				%>
			</tbody>
		</table>
		<%
		}

		HttpSession session1 = request.getSession();
		String user = (String) session1.getAttribute("LOGGED_IN_USER");
		if (user != null) {
		out.println("Being an ADMIN, you have the priviledge access to change the bike specification from the database");
		%>
		<form action="RemoveBikeServlet">
			<h6>Remove the bike</h6>
			<label for="noPlate"><strong>Enter Plate no. of bike
					to be removed: </strong></label> <input type="text" id="noPlate" name="noPlate"
				required="required">
			<button class="btn btn-danger">Remove</button>
		</form>

		<p>
			############################################################################################</p>
		Message:
		<jsp:include page="message.jsp"></jsp:include>
		<p>
			############################################################################################</p>

		<form action="UpdateBikeServlet">
			<h6>Modify the existing bike</h6>

			<label for="noPlate"><strong>Enter Plate no. of bike
					to update: </strong></label> <input type="text" id="noPlate" name="noPlate"
				required="required"><br> <br> <label for="km"><strong>Update
					Odometer reading: </strong></label> <input type="number" id="km" name="km" min=1
				max=300000 required="required"> <label for="price"><strong>Update
					price: </strong></label> <input type="number" id="price" name="price" min=1
				max=200000 required="required"><br>


			<button class="btn btn-primary">Update</button>
			<button type="reset" class="btn btn-secondary">Reset</button>

		</form>
		<%
		}
		%>
	</main>
</body>
</html>
