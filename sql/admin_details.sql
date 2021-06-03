CREATE TABLE admin_details(
admin_name VARCHAR(20) NOT NULL,
admin_id VARCHAR(15) NOT NULL PRIMARY  KEY,
admin_password VARCHAR(20) NOT NULL
);

SELECT * FROM admin_details;
DROP TABLE admin_details;

DELETE FROM admin_details WHERE admin_id='ven123';
INSERT INTO admin_details (admin_name, admin_id, admin_password) VALUES ('Venkatesh','ven123','Venkatesh@123');