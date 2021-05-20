<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add new bikes</title>
<style>
div .form {
	margin-bottom: 50px;
}

label {
	display: inline-block;
	width: 250px;
	color: #000000;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>Add upcoming bikes</h2>
		<br>
		<form action="Addbikeservlet" method="GET">
			<div class="form">
				<label for="bikeManufacturer"><strong>Enter Bike
						Manufacturer:</strong></label> <input type="text" id="bikeManufacturer"
					name="bikeManufacturer" required autofocus autocomplete="on"
					placeholder="Enter Bike Manufacturer name"> <br>
			</div>

			<div class="form">
				<label for="bikeModel"><strong>Bike Model:</strong></label> <input
					type="text" id="bikeModel" name="bikeModel" required
					autocomplete="on" placeholder="Enter Bike model here"> <br>
			</div>

			<div class="form">
				<label for="bikeColor"><strong>Bike Color:</strong></label> <input
					type="text" id="bikeColor" name="bikeColor" required
					autocomplete="on" placeholder="Enter Bike color here"> <br>
			</div>

			<div class="form">
				<label for="km"><strong>Current Odometer Reading:</strong></label> <input
					type="number" id="km" name="km" min=0 max=99999999 required
					placeholder="Enter in Km"> Km <br>
			</div>

			<div class="form">
				<label for="manufactureYear"><strong>Year of
						Manufacture:</strong></label> <input type="number" id="manufactureYear"
					name="manufactureYear" min=1900 required placeholder="Enter Year">
				<br>
			</div>

			<div class="form">
				<label for="fuelType"><strong>Fuel type:</strong></label> <select
					id="fuelType" name="fuelType">
					<option disabled>--Select fuel Type--</option>
					<option value="Petrol">Petrol</option>
					<option value="Diesel">Diesel</option>
					<option value="Gas">Gas</option>
					<option value="Electric">Electric</option>
				</select><br>
			</div>

			<div class="form">
				<label for="vin"><strong>Vehicle Identification
						Number:</strong></label> <input type="text" id="vin" name="vin" required
					autocomplete="on" placeholder="Enter VIN here"> <i>(17
					Digit Alphanumeric)</i><br>
			</div>

			<div class="form">
				<label for="noPlate"><strong>Number Plate:</strong></label> <input
					type="text" id="noPlate" name="noPlate" required autocomplete="on"
					placeholder="Enter Number Plate"> <em>Format eg.
					TN67E3454</em><br>
			</div>

			<div class="form">
				<label for="price"><strong>Estimated Price:</strong></label> <input
					type="number" id="price" name="price" min="1" max ="300000" required
					placeholder="Enter Price here"> <em>Excluding GST and
					Insurance</em><br>
			</div>

			<div class="form">
				<strong> Status: &emsp; &emsp;</strong> 
				<input type="radio"	name="status" value="true">Verified
				 <input type="radio"name="status" value="false" required>Not Verified 
				 <br> <br>
			</div>

			<br><jsp:include page="message.jsp"></jsp:include><br>

			<button class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-danger">Reset</button>

		</form>
	</main>


</body>
</html>