CREATE TABLE bike_specification (
	bike_manufacturer VARCHAR(20) NOT NULL,
	bike_model VARCHAR(20) NOT NULL,
	bike_color VARCHAR(20) NOT NULL,
	bike_price FLOAT NOT NULL,
	odometer_reading INTEGER NOT NULL,
	manufacture_year INTEGER NOT NULL,
	status BOOLEAN NOT NULL,
	fuel_type VARCHAR(10)NOT NULL,
	vin CHAR(17) NOT NULL UNIQUE,	
	plate_no CHAR(11) NOT NULL PRIMARY KEY
);
	