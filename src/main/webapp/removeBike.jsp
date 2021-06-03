<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Remove bike</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form onsubmit="getBike()">
			<h6>Remove the bike</h6>
			<jsp:include page="message.jsp"></jsp:include>
			<p>
				<label for="noPlate"><strong>Enter Plate no. of
						bike to be removed: </strong></label> <input type="text" id="plateNo"
					name="plateNo" required="required">
				<button class="btn btn-secondary">Enter</button>
		</form>

		<p id="details"></p>
		<br>
		<button class="btn btn-danger" style="visibility: hidden"
			id="continue" type="button" onclick="removeBike()">Confirm
			Remove</button>
		<br><jsp:include page="message.jsp"></jsp:include>

		<script>

function getBike(){
	event.preventDefault();
	console.log("Fetching bike ");
	let plateNo = document.querySelector("#plateNo").value;
	let url = "GetByPlateNoServlet?noPlate=" + plateNo;
	fetch(url).then(res=> res.json()).then(res=>{
		let bike = res;
		console.log("Got response from servlet");
		let content = "";
		if(bike==null || bike.errorMessage != null){
			console.log(bike);
			alert(bike.errorMessage);
		}
		else {
		console.log(bike.status);
		let status = "Not Verified"
		if(bike.status){
			status = "Verified";
		}
		console.log(status);
		content += "<br><p> Bike Manufacturer: " + bike.bikeManufacturer + "</p><p> Bike Model: "+ bike.bikeModel + "</p><p>Bike Color: " + bike.bikeColor + "</p><p>Bike Price: " + bike.bikePrice +"</p><p>Odometer reading: " + bike.km +"</p><p> Manufacture Year: " + bike.manufactureYear + "</p><p> Status: " + status + "</p><p>Fuel Type: " + bike.engineDetails.fuelType + "</p><p>VIN: " + bike.engineDetails.vin +"</p>"; 
		console.log(content);
		document.getElementById("continue").style.visibility = "visible";	

		}
		document.querySelector("#details").innerHTML= content;
	})	
}


function removeBike(){
	event.preventDefault();
	let plateNo = document.querySelector("#plateNo").value;
	let url ="RemoveBikeServlet?noPlate=" + plateNo;
	
	fetch(url).then(res=> res.json()).then(res=>{
		alert("Successfully Removed");
		window.location.href="DisplayBikesServlet";
	});
}


</script>

	</main>
</body>
</html>