<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add bike</title>
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
		<br><h2>Add upcoming bike</h2>
		<br>
		<form action="Addbikeservlet" method="GET" autocomplete="on">
			<div class="form">
				<label for="bikeManufacturer"><strong>Enter Bike
						Manufacturer:</strong></label> <input type="text" id="bikeManufacturer"
					name="bikeManufacturer" minlength="2" maxlength="20" required
					autofocus placeholder="Enter Bike Manufacturer name"> <br>
			</div>

			<div class="form">
				<label for="bikeModel"><strong>Bike Model:</strong></label> <input
					type="text" id="bikeModel" name="bikeModel" minlength="2"
					maxlength="20" required placeholder="Enter Bike model here">
				<br>
			</div>

			<div class="form">
				<label for="bikeColor"><strong>Bike Color:</strong></label> <input
					type="text" id="bikeColor" name="bikeColor" minlength="2"
					maxlength="20" required placeholder="Enter Bike color here">
				<br>
			</div>

			<div class="form">
				<label for="km"><strong>Current Odometer Reading:</strong></label> <input
					type="number" id="km" name="km" min=0 max=200000 required
					placeholder="Enter in Km"> Km <br>
			</div>

			<div class="form">
				<label for="manufactureYear"><strong>Year of
						Manufacture:</strong></label> <input type="number" id="manufactureYear"
					name="manufactureYear" min=1970 max=2021 required
					placeholder="Enter Year"> <br>
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
					placeholder="Enter VIN here"> <em>(17 Digit
					Alphanumeric)</em><br>
			</div>

			<div class="form">
				<label for="noPlate"><strong>Number Plate:</strong></label> <input
					type="text" id="noPlate" name="noPlate" required maxlength="11"
					minlength="9" placeholder="Enter Number Plate"> <em>Format
					eg. TN67E3454</em><br>
			</div>

			<div class="form">
				<label for="price"><strong>Estimated Price:</strong></label> <input
					type="number" id="price" name="price" min="0" max="300000" required
					placeholder="Enter Price here"> <em>Excluding GST and
					Insurance</em><br>
			</div>
			<br/>
			<h3>Owner Details</h3>
			
			<label for="ownerName"><strong>Enter name of Bike owner:</strong></label> <input type="text" id="ownerName"
					name="ownerName" minlength="2" maxlength="20" required
					autofocus placeholder="Enter Bike Owner name"> <br>
			</div>

			<div class="form">
				<label for="ownerAddress"><strong>Enter Bike owner Address:</strong></label> <textarea
					type="text" id="ownerAddress" name="ownerAddress" minlength="5"
					maxlength="200" required placeholder="Enter Bike Owner Address here"></textarea>
				<br>

			<label for="ownerPhoneNo"><strong>Enter Bike owner Mobile no:</strong></label> <input type="number" id="ownerPhoneNo"
					name="ownerPhoneNo"  required
					autofocus placeholder="Enter Bike Owner Phone no."> <br>
			</div>

			<br><jsp:include page="message.jsp"></jsp:include><br>

			<button class="btn btn-primary">Submit</button>

			<button type="reset" class="btn btn-danger">Reset</button>

		</form>
	</main>


</body>