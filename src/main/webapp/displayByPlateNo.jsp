<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.dilshad.model.BikeDefault"%>
<%@page import="in.dilshad.model.BikeSpecification"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.dilshad.service.BikeManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 40%;
	border-radius: 5px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

img {
	border-radius: 5px 5px 0 0;
}

.container {
	padding: 2px 16px;
}
</style>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bike Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>Bike Details</h2><br>
		<%
		BikeSpecification bikeSpecification = (BikeSpecification) request.getAttribute("BIKE_SPECIFICATION");
		
		if(bikeSpecification == null){
			out.println("No Reccords");
		}
		else{
		
		%>

		<div class="card">
			<%
			out.println(
					"<p> <strong>" + "Plate No.: " + "</strong>" + bikeSpecification.getEngineDetails().get("noPlate") + "</p>");
			%>
			<img
				src="https://www.drivespark.com/bikes-photos/models/450x350/ct100_1515499232.jpg/3/x.pagespeed.ic.367gLOJb09.jpg"
				alt="Bike image" style="width: 100%">

			<div class="container"
				style="background-color: rgb(60, 179, 113, 0.3);">
				<%
				
				out.println("<p> <strong>" + "Manufacturer: " + "</strong>" + bikeSpecification.getBikeManufacturer() + "</p>");
				out.println("<p> <strong>" + "Model: " + "</strong>" + bikeSpecification.getBikeModel() + "</p>");
				out.println("<p> <strong>" + "Color: " + "</strong>" + bikeSpecification.getBikeColor() + "</p>");
				out.println("<p> <strong>" + "Price: " + "</strong>" + bikeSpecification.getBikePrice() + "</p>");
				out.println("<p> <strong>" + "Oddometer Reading: " + "</strong>" + bikeSpecification.getKm() + "Km" + "</p>");
				out.println("<p> <strong>" + "Manufacturer Year: " + "</strong>" + bikeSpecification.getManufactureYear() + "</p>");
				out.println(
						"<p> <strong>" + "Fuel Type: " + "</strong>" + bikeSpecification.getEngineDetails().get("fuelType") + "</p>");
				out.println("<p> <strong>" + "VIN: " + "</strong>" + bikeSpecification.getEngineDetails().get("vin") + "</p>");
				%>
			</div>
			
			<%} %>
		</div>
	</main>
</body>
</html>