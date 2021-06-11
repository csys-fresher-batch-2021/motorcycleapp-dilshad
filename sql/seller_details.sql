CREATE TABLE seller_details (
 	seller_bike_no VARCHAR(11) PRIMARY KEY NOT null, 
	seller_name VARCHAR(20) NOT NULL,
	seller_address VARCHAR(200)NOT NULL, 
	seller_mobile_no BIGINT NOT NULL,
	created_date timestamp NOT NULL DEFAULT current_timestamp
);

DROP TABLE seller_details;
SELECT * FROM seller_details;


--Sample query
INSERT INTO seller_details(seller_bike_no,  seller_name,  
						  seller_address,  seller_mobile_no)
						  VALUES ('KL23FR5498', 'Dinesh',
								 '74, South car street, (near Repco Bank), Sivakasi 626123', '9867675453'
								 );
