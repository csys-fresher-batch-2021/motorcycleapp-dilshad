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
table, th, td {
	border: 2px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Bike list</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<%
		Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
		%>
		<br>
		<br>
		<table>
			<caption>List of Bikes</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Manufacturer</th>
					<th scope="col">Model</th>
					<th scope="col">Color</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 1;
				for (BikeSpecification bike : bikeList.values()) {
					out.print("<tr>");
					out.print("<td>" + i + "</td>");
					out.print("<td>" + bike.bikeManufacturer + "</td>");
					out.print("<td>" + bike.bikeModel + "</td>");
					out.print("<td>" + bike.bikeColor + "</td>");
					out.print("<td>" + bike.bikePrice + "</td>");
					out.print("</tr>");
					i++;
				}
				%>
			</tbody>
		</table>
	</main>

</body>
</html>