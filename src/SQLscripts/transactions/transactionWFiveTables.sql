-- Get stock form reqFacility from vendor reqVendor 
-- and sort it by price of product
SELECT Stock.*
FROM Stock NATURAL JOIN Sells NATURAL JOIN Product
WHERE Stock.facilityID = reqFacility AND Sells.vendorID = reqVendor
ORDER BY Product.price;