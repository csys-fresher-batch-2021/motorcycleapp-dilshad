CREATE TABLE Bike_Specification (
	Bike_Manufacturer VARCHAR(20) NOT NULL,
	Bike_Model VARCHAR(20) NOT NULL,
	Bike_color VARCHAR(20) NOT NULL,
	Bike_Price FLOAT NOT NULL,
	Odometer_Reading INTEGER NOT NULL,
	Manufacture_Year INTEGER NOT NULL,
	Status BOOLEAN NOT NULL,
	Fuel_Type VARCHAR(10)NOT NULL,
	VIN CHAR(17) NOT NULL UNIQUE,	
	Plate_No CHAR(11) NOT NULL PRIMARY KEY
);

DROP TABLE Bike_Specification
SELECT * FROM Bike_Specification