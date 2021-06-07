
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

		<h3>Short list Available bikes by price</h3>
		<form onsubmit="getAllBikes()">
			<label for="min">Set minimum limit: </label> <input type="number"
				id="min" name="min" min=0 max=299999 autofocus> <label
				for="max">Set maximum limit: </label> <input type="number" id="max"
				name="max" min=1 max=300000 autofocus><br>
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
				let max = document.querySelector("#max").value;
				let min = document.querySelector("#min").value;
				let url = "ShortlistByPriceServlet?minv=" + min + "&maxv=" +max;
			
				fetch(url).then(res=> res.json()).then(res=>{
					let bikes = res;
					if (res ==null || res.errorMessage != null){
						alert(res.errorMessage);
					}
					else {
						
					
					console.log("Got response from servlet");
					
					let content = "";
					var count =1;
					for(let bike of bikes){
						let status = "Not Verified";
						if(bike.status)
							status = "Verified";
						content += "<tr><td>" + count + "</td><td>" + bike.engineDetails.noPlate +"</td><td>"+ bike.bikeManufacturer+"</td><td>"+ bike.bikeModel + "</td><td>" + bike.bikeColor + "</td><td>" + bike.km +" Km</td><td>Rs." + bike.bikePrice +"/-</td></tr>"; 
					count++;
					}
					console.log(content);
					
					
					document.querySelector("#details").innerHTML= content;
					}
					
				})
				
			}
			</script>

	</main>
</body>
</html>