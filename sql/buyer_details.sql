CREATE TABLE buyer_details (
	buyer_name VARCHAR(20) NOT NULL,
	buyer_id VARCHAR(15) NOT NULL UNIQUE,
	buyer_password VARCHAR(25) NOT NULL,
	buyer_mobile_no BIGINT NOT NULL UNIQUE
);

DROP TABLE buyer_details;
DELETE FROM buyer_details;
SELECT * FROM buyer_details;


INSERT INTO buyer_details(buyer_name,  buyer_id,
						  buyer_password,  buyer_mobile_no)
						  VALUES ('Ganesh', 'gan234',
								 'Ganesh234', '9861235453');
								 
								 
INSERT INTO buyer_details(buyer_name,  buyer_id,
						  buyer_password, buyer_mobile_no)
						  VALUES ('Lingesh', 'lin234',
								 'Lingesh234', '7783462734');
								 
