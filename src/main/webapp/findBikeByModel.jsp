<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="assets/css/table_style.css">

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

		<table>
			<caption>List of Bikes</caption>

			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Plate no.</th>
					<th scope="col">Manufacturer</th>
					<th scope="col">Model</th>
					<th scope="col">Color</th>
					<th scope="col">Km Driven</th>
					<th scope="col">Price(Rs.)</th>
				</tr>
			</thead>
			<tbody id="details">

			</tbody>
		</table>



		<script>
		function getAllBikes(){
			event.preventDefault();
			console.log("Fetching all bikes ");
			let manufacturer = document.querySelector("#manufacturer").value;
			let model = document.querySelector("#model").value;
			let url = "FindBikeByModelServlet?manufacturer=" + manufacturer + "&model=" +model;
		
			fetch(url).then(res=> res.json()).then(res=>{
				let bikes = res;
				
				let content = "";

				if(bikes==null || bikes.errorMessage != null){
					alert(bikes.errorMessage);
				}else{
					let count = 1;
				for(let bike of bikes){
					let status = "Not Verified";
					if(bike.status)
						status = "Verified";
					
					content += "<tr><td>" + count + "</td><td>" + bike.engineDetails.noPlate +"</td><td>"+ bike.bikeManufacturer+"</td><td>"+ bike.bikeModel + "</td><td>" + bike.bikeColor + "</td><td>" + bike.km +" Km</td><td>Rs." + bike.bikePrice +"/-</td></tr>"; 
					count++; 
				}
				}
				document.querySelector("#details").innerHTML= content;
				
			})
			
		}
		</script>

	</main>
</body>
</html>