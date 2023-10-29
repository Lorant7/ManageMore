-- Get stock form reqFacility from vendor reqVendor 
-- and sort it by price of product
SELECT Stock.*
FROM Stock NATURAL JOIN Facility NATURAL JOIN Purchases NATURAL JOIN Product NATURAL JOIN Vendor
WHERE Facility.facilityID = reqFacility AND Vendor.vendorID = reqVendor
ORDER BY Product.price;