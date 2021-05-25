<!Doctype>
<html lang="en">
<head>
<style>
table {
	border-collapse: collapse;
	width: 70%;
}

th, td {
	text-align: left;
	padding: 8px;
}

th {
	background-color: rgba(116, 75, 212, 0.5);
	color: white;
}
</style>

<title>Motorcycle</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<header>
			<h1 style="text-align: center; color: Indigo">Welcome to
				Motorcycle Show Room</h1>
		</header>
		<ol>
			<li><a href="addBike.jsp"><strong>Add bike</strong> </a></li>
			<li><a href="bikeList.jsp"><strong>Show Currently
						available bikes</strong> </a></li>
			<li><a href="searchByPlateNo.jsp"><strong>Search
						Bike by plate Number</strong> </a></li>
			<li><a href="displayByPlateNoJSON.jsp"><strong>Search
						Bike by plate Number (Using Json)</strong> </a></li>
		</ol>
		<article class="column">
			<h3>About us</h3>
			<p>
				<img src="assets/images/showroom.png" alt="Motorcycle Show room"
					style="width: 400px; height: 280px; margin-left: 15px; float: right;">

				We offer a veritable platform that deals with Used Bikes, Booking
				and acts as a knowledge hub for everything related to two-wheelers.
				We have rich collection of used motorcycles of all models that are
				in good condition and best quality. We also strive to give expert
				advice to our users on their queries, provide information regarding
				insurance and loan, generate original test drive reviews, helps to
				locate Bike Dealers (both new and used bikes) and a lot more.
			</p>

		</article>
		<article>
			<h4>Benefits</h4>
			<ol>
				<li>People who migrate can purchase used bikes for temporary
					usage.</li>
				<li>Situation in which you may use vehicle only weekly or
					monthly etc.</li>
				<li>Used bikes may costs only half of the new bike price.</li>
				<li>Useful for people who wants to own vehicle at low budget.</li>
				<li>Additional features could be included based on the
					requirement.</li>
			</ol>
		</article>

		<h4>Services</h4>
		<ul>
			<li>Bike Valuation</li>
			<li>Two-wheeler Finance</li>
			<li>Featured Listing</li>
			<li>Used Bike Dealer Plan</li>
			<li>Two-wheeler Insurance</li>
		</ul>

		<footer style="background-color: SlateBlue;">
			<p>Make Hay While the Sun Shines.</p>
		</footer>


	</main>
</body>
</html>
