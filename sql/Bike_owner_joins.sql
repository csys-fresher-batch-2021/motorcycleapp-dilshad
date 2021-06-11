
-- Gets partial bike specification details + owner details from two tables.
--Plate number is the primary key.
SELECT bike_specification.plate_no, bike_specification.bike_model, seller_details.seller_name, seller_details.seller_address, seller_details.seller_mobile_no, seller_details.created_date
FROM (bike_specification INNER JOIN seller_details ON bike_specification.plate_no = seller_details.seller_bike_no)
WHERE bike_specification.status = 'false'
ORDER BY seller_details.created_date ASC;