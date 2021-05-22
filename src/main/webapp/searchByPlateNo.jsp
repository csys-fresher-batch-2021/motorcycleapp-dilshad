<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.dilshad.model.BikeDefault"%>
<%@page import="in.dilshad.model.BikeSpecification"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.dilshad.service.BikeManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bike</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>Search the Bike using Plate Number</h2>
		<div style="text-align: center;">
			<form action="displayByPlateNo.jsp">
				<label for="plateNo"><strong>Enter the Plate
						Number: </strong></label> <input type="text" id="noPlate" name="noPlate" required
					placeholder="Plate Number" autofocus>
				<button class="btn btn-info">Search</button>
			</form>
		</div>
		<%
		BikeSpecification bikeSpecification = new BikeSpecification();
		Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
		//String plateNo = (request.getParameter("noPlate").trim());
		%>
		<table>
			<thead>
				<tr>
					<th>S.no</th>
					<th>Plate number</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 1;
				for (String bikes : bikeList.keySet()) {
					out.println("<tr>");
					out.println("<td>" + i + "</td>");
					out.println("<td>" + bikes + "</td>");
					out.println("</tr>");
					i++;
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>