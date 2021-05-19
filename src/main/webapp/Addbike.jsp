<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
				<label for="bikeManufacturer"><b>Enter Bike
						Manufacturer:</b></label> <input type="text" id="bikeManufacturer"
					name="bikeManufacturer" required autofocus autocomplete="on"
					placeholder="Enter Bike Manufacturer name"> <br>
			</div>

			<div class="form">
				<label for="bikeModel"><b>Bike Model:</b></label> <input type="text"
					id="bikeModel" name="bikeModel" required autocomplete="on"
					placeholder="Enter Bike model here"> <br>
			</div>

			<div class="form">
				<label for="bikeColor"><b>Bike Color:</b></label> <input type="text"
					id="bikeColor" name="bikeColor" required autocomplete="on"
					placeholder="Enter Bike color here"> <br>
			</div>

			<div class="form">
				<label for="km"><b>Current Odometer Reading:</b></label> <input
					type="number" id="km" name="km" min=0 max=99999999 required
					placeholder="Enter in Km"> Km <br>
			</div>

			<div class="form">
				<label for="manufactureYear"><b>Year of Manufacture:</b></label> <input
					type="number" id="manufactureYear" name="manufactureYear" min=1900
					required placeholder="Enter Year"> <br>
			</div>

			<div class="form">
				<label for="fuelType"><b>Fuel type:</b></label> <select
					id="fuelType" name="fuelType">
					<option disabled>--Select fuel Type--</option>
					<option value="Petrol">Petrol</option>
					<option value="Diesel">Diesel</option>
					<option value="Gas">Gas</option>
					<option value="Electric">Electric</option>
				</select><br>
			</div>

			<div class="form">
				<label for="vin"><b>Vehicle Identification Number:</b></label> <input
					type="text" id="vin" name="vin" required autocomplete="on"
					placeholder="Enter VIN here"> <i>(17 Digit
					Alphanumeric)</i><br>
			</div>

			<div class="form">
				<label for="noPlate"><b>Number Plate:</b></label> <input type="text"
					id="noPlate" name="noPlate" required autocomplete="on"
					placeholder="Enter Number Plate"> <i>Format eg.
					TN67E3454</i><br>
			</div>

			<div class="form">
				<label for="price"><b>Estimated Price:</b></label> <input
					type="number" id="price" name="price" min=1 max=250000 required
					placeholder="Enter Price here"> <i>Excluding GST &
					Insurance</i><br>
			</div>

			<div class="form">
				<b> Status: &emsp; &emsp;</b> <input type="radio" name="status"
					value="Verified" />Verified <input type="radio" name="status"
					value="Pending" required />Not Verified <br>
				<br>
			</div>

			<br><jsp:include page="message.jsp"></jsp:include><br>

			<button class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-danger">Reset</button>

		</form>
	</main>


</body>
</html>