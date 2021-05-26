<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form onsubmit="getAllTasks()">

		<label for="plateNo">Enter platNo :</label> <input type="text"
			required="required" id="plateNo" name="plateNo">


		<button>Search</button>
	</form>

	<table>
		<caption>Bike Details</caption>
		<thead>
			<tr>
				<th scope="col">Manufacturer</th>
				<th scope="col">Model</th>
				<th scope="col">Color</th>
				<th scope="col">Price</th>
				<th scope="col">Km</th>
				<th scope="col">Year</th>
			</tr>
		</thead>
		<tbody id="task-tbl">

		</tbody>
	</table>
	<script>

function getAllTasks(){
	event.preventDefault();
	console.log("Fetching all tasks ");
	let plateNo = document.querySelector("#plateNo").value;//"KA67A0000"
	let url = "SearchByPlateNoJsonServlet?noPlate=" + plateNo;
	fetch(url).then(res=> res.json()).then(res=>{
		let bike = res;
		console.log("Got response from servlet");
		//console.log(bikes);
		
		let content = "";
		
			content += "<tr><td>" + bike.bikeManufacturer + "</td><td>"+ bike.bikeModel + "</td><td>" + bike.bikeColor + "</td><td>" + bike.bikePrice +"</td><td>" + bike.km +"</td><td>" + bike.manufactureYear + "</td></tr>";
			console.log(bike.bikeManufacturer);
			console.log(bike.bikeModel);
			console.log(bike.bikeColor);
			console.log(bike.bikePrice);
			console.log(bike.km);
			console.log(bike.manufactureYear);
		
		console.log(content);
		
		document.querySelector("#task-tbl").innerHTML= content;
		
	})
	
}



</script>
</body>
</html>