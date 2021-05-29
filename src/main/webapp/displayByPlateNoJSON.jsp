<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
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

.details {
	font-size: 25px;
	color: rgb(60, 30, 0);
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Bike Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br> <br>
		<form onsubmit="getAllTasks()">
			<label for="plateNo">Enter plateNo :</label> <input type="text"
				required="required" id="plateNo" name="plateNo">
			<button>Search</button>
		</form>
		<br>
		<div class="card">
			<p id="noPlate"></p>
			<img id="img"
				src="https://www.drivespark.com/bikes-photos/models/450x350/ct100_1515499232.jpg/3/x.pagespeed.ic.367gLOJb09.jpg"
				alt="Bike image" style="width: 100%">

			<div class="container"
				style="background-color: rgb(120, 279, 113, 0.3);">
				<strong><article id="details" class="details"></article></strong>

			</div>
		</div>
		<script>

function getAllTasks(){
	event.preventDefault();
	console.log("Fetching all tasks ");
	let plateNo = document.querySelector("#plateNo").value;
	let url = "SearchByPlateNoJsonServlet?noPlate=" + plateNo;
	fetch(url).then(res=> res.json()).then(res=>{
		let bike = res;
		console.log("Got response from servlet");
		
		let content = "";
		content += "<br><p> Bike Manufacturer: " + bike.bikeManufacturer + "</p><p> Bike Model: "+ bike.bikeModel + "</p><p>Bike Color: " + bike.bikeColor + "</p><p>Bike Price: " + bike.bikePrice +"</p><p>Odometer reading: " + bike.km +"</p><p> Manufacture Year: " + bike.manufactureYear + "</p><p> Status: " + bike.status + "</p><p>Fuel Type: " + bike.engineDetails.fuelType + "</p><p>VIN: " + bike.engineDetails.vin +"</p>"; 
		console.log(bike);
		console.log(content);
		let header = "<h5> Plate Number: "+plateNo;
		document.querySelector("#noPlate").innerHTML = header;
		document.querySelector("#details").innerHTML= content;
		
	})
	
}
</script>
	</main>
</body>
</html>