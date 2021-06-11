<%@page import="in.dilshad.dto.UnverifiedBikeDTO"%>
<%@page import="in.dilshad.model.BikeSpecification"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>

<%@page import="in.dilshad.model.BikeSpecification"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
	<h3>List of bikes yet to verify</h3>
		<%
		List<UnverifiedBikeDTO> bikeList = (List<UnverifiedBikeDTO>) request.getAttribute("TO_VERIFY_DETAILS");
		if (bikeList == null)
			out.print("No pending work");
		else {
		%>

		<table class="table table-bordered">
			<caption>This Table shows the list of bikes to be verified</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="plateNo">Plate no.</th>
					<th id="bikeModel">Bike model</th>
					<th id="ownerName">Owner name</th>
					<th id="ownerAddress">Location</th>
					<th id="ownerphoneNo">Phone no.</th>
					<th id="time">Added Time</th>

					<th id="action">Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				int i = 0;
				for (UnverifiedBikeDTO bike : bikeList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=bike.getPlateNo()%></td>
					<td><%=bike.getBikeModel()%></td>
					<td><%=bike.getOwnerName()%></td>
					<td><%=bike.getOwnerAddress()%></td>
					<td><%=bike.getOwnerPhoneNo()%></td>
					<td><%=bike.getAddedTime()%></td>

					<td><a
						href="UpdateBikeStatusServlet?plateNo=<%=bike.getPlateNo()%>"
						class=" btn btn-danger">Verify</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>


		<%
		}
		%>
	</main>

</body>
</html>