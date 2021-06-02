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

		<h3>Short list Available bikes by price</h3>
		<form onsubmit="getAllBikes()">
			<label for="min">Set minimum limit: </label> <input type="number"
				id="min" name="min" min=0 max=299999 autofocus> <br> <br>
			<br> <label for="max">Set maximum limit: </label> <input
				type="number" id="max" name="max" min=1 max=300000 autofocus>
				<br> <br> <br>
			<button class="btn btn-info">Search</button>
		</form>
		
		<form>
    
</form>
		<p id="details"></p>

		<script>
		function getAllBikes(){
			event.preventDefault();
			console.log("Fetching all bikes ");
			let max = document.querySelector("#max").value;
			let min = document.querySelector("#min").value;
			let url = "ShortlistByPriceServlet?minv=" + min + "&maxv=" +max;
		
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