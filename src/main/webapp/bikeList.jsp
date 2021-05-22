<%@page import="in.dilshad.model.BikeDefault"%>
<%@page import="in.dilshad.model.BikeSpecification"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.dilshad.service.BikeManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="em">
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
<title>Bike list</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


		<br> <br>
		<h4>List of Available bikes</h4>
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
				Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
				int i = 1;
				for (BikeSpecification bike : bikeList.values()) {
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
	</main>

</body>
</html>