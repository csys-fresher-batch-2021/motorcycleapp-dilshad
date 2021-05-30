<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title>Find bikes</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<h3>Find available Bikes by your choice</h3>
		<form onsubmit="getAllBikes()">
			<label for="manufacturer">Bike Manufacturer: </label> <input
				type="text" id="manufacturer" name="manufacturer" maxlength="20"
				autofocus placeholder="Enter company name"> <br> <em>e.g.
				TVS, Hero, Bajaj etc.</em> <br> <br> <label for="model">Bike
				Model: </label> <input type="text" id="model" name="model" maxlength="20"
				placeholder="Enter bike model"><br> <em>e.g.
				Splendor, Active etc.</em><br> <br>
			<button class="btn btn-info">Search</button>
		</form>
		<p id="details"></p>

		<script>
		function getAllBikes(){
			event.preventDefault();
			console.log("Fetching all bikes ");
			let manufacturer = document.querySelector("#manufacturer").value;
			let model = document.querySelector("#model").value;
			let url = "FindBikeByModelServlet?manufacturer=" + manufacturer + "&model=" +model;
		
			fetch(url).then(res=> res.json()).then(res=>{
				let bikes = res;
				console.log("Got response from servlet");
				
				let content = "";
				for(let bike of bikes){
					let status = "Not Verified";
					if(bike.status)
						status = "Verified";
				content += "<br><p>Plate Number: " + bike.engineDetails.noPlate + "</p><p> Bike Manufacturer: " + bike.bikeManufacturer + "</p><p> Bike Model: "+ bike.bikeModel + "</p><p>Bike Color: " + bike.bikeColor + "</p><p>Bike Price: " + bike.bikePrice +"</p><p>Odometer reading: " + bike.km +"</p><p> Manufacture Year: " + bike.manufactureYear + "</p><p> Status: " + status + "</p><p>Fuel Type: " + bike.engineDetails.fuelType + "</p><p>VIN: " + bike.engineDetails.vin +"</p>"; 
				}
				console.log(content);
				
				document.querySelector("#details").innerHTML= content;
				
			})
			
		}
		</script>

	</main>
</body>
</html>