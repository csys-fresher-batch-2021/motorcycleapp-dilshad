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


--Sample bike_details 1:
INSERT INTO bike_specification(bike_manufacturer, bike_model, 
							   bike_color, bike_price,  
							   odometer_reading, manufacture_year,
							   status, fuel_type,
							   vin, plate_no ) 
							   VALUES ('TVS',  'Apache180', 
									   'Red', '47800', 
									   '78955', '2002', 
									   'true', 'Petrol', 
									   'EDIO3456KO22OK4ML','KL23FR5498');
									   

									   
--Sample bike_details 2:
INSERT INTO bike_specification(bike_manufacturer, bike_model, 
							   bike_color, bike_price,  
							   odometer_reading, manufacture_year,
							   status, fuel_type,
							   vin, plate_no ) 
							   VALUES ('TVS',  'iQube', 
									   'White', '100800', 
									   '58955', '2010', 
									   'true', 'Electric', 
									   'MTTQ9OEKO22OK4ML2','TN23ER3487');
	
									   
--Sample bike_details 3:								   
INSERT INTO bike_specification(bike_manufacturer, bike_model, 
							   bike_color, bike_price,  
							   odometer_reading, manufacture_year,
							   status, fuel_type,
							   vin, plate_no ) 
							   VALUES ('Hero',  'Splendor', 
									   'Blue', '22500', 
									   '58955', '2007', 
									   'true', 'Petrol', 
									   'LPTQ9O12322OK4ML2','TN98ER3421');
	
									   
--Sample bike_details 4:	
INSERT INTO bike_specification(bike_manufacturer, bike_model, 
							   bike_color, bike_price,  
							   odometer_reading, manufacture_year,
							   status, fuel_type,
							   vin, plate_no ) 
							   VALUES ('Ather',  'Ather450X', 
									   'Gray', '72500', 
									   '51955', '2011', 
									   'false', 'Electric', 
									   'JIKL3412322OK4ML2','TN91EZ2399');
--Delete Query
DELETE FROM bike_specification WHERE plate_no = 'TN91EZ2399';									   