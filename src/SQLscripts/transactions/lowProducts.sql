-- Get all of the products in the stock of reqFacility
-- that are below the desired_amount
SELECT S*
FROM Stock AS S
WHERE S.amount < S.desired_amount AND S.facilityID = reqFacilitID;