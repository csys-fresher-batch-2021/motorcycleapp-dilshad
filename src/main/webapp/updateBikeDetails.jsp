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
						bike to update: </strong></label> <input type="text" id="noPlate" name="noPlate"
					required="required"><br> <br> 

				<button class="btn btn-primary">Enter</button>
		</form>

<p id="details"></p>

		<form onsubmit="updateBike()" style="visibility: hidden"
			id="continue">
			<h6>Remove the bike</h6>
			<jsp:include page="message.jsp"></jsp:include>
			<p>
				 <label for="km"><strong>Update
						Odometer reading: </strong></label> <input type="number" id="km" name="km" min=1
					max=300000 required="required"> <label for="price"><strong>Update
						price: </strong></label> <input type="number" id="price" name="price" min=1
					max=120000 required="required"><br>

 <button class="btn btn-danger" type="button" onclick="updateBike()">Confirm
			Update</button>
							<button type="reset" class="btn btn-secondary">Reset</button>
			
				
		</form>

		
		<br>
		<!-- <button class="btn btn-danger" style="visibility: hidden"
			id="continue" type="button" onclick="updateBike()">Confirm
			Remove</button> -->

		
		
		<script type="text/javascript">	

function getBike(){
	//document.querySelector("#km").setAttribute("min", bike.km);
	event.preventDefault();
	console.log("Fetching bike ");
	let plateNo = document.querySelector("#noPlate").value;
	let url = "GetByPlateNoServlet?noPlate=" + plateNo;
	fetch(url).then(res=> res.json()).then(res=>{
		let bike = res;
		console.log("Got response from servlet \n", res);	
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
		//document.querySelector("#km").setAttribute("min", bike.km);
		document.getElementById("continue").style.visibility = "visible";	

		}
		document.querySelector("#details").innerHTML= content;
	})	
}
function updateBike(){
	event.preventDefault();
	let plateNo = document.querySelector("#noPlate").value;
	let km = document.querySelector("#km").value;
	let price = document.querySelector("#price").value;
	let url ="UpdateBikeServlet?noPlate="+plateNo +"&km="+km +"&price="+price;
	
	fetch(url).then(res=> res.json()).then(res=>{
		alert("Successfully Updated");
		window.location.href="DisplayBikesServlet";
	});
}

</script>


	</main>
</body>
</html>