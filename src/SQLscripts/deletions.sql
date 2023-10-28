-- Employee
DELETE FROM Employee
WHERE employeeID = reqEmployeeID;

DELETE FROM Employee
WHERE name = reqName;

-- Facility
DELETE FROM Facility
WHERE facilityID = reqFacilityID;

DELETE FROM Facility
WHERE name = reqFacilityName;

-- Stock
DELETE FROM Stock
WHERE productID = reqProductID AND facilityID = reqFacilityID;

DELETE FROM Stock
WHERE facilityID = reqFacilityID;

-- Vehicle
DELETE FROM Vehicle
WHERE vehicleID = reqVehicleID;

-- Vendor
DELETE FROM Vendor
WHERE vendorID = reqVendorID;

DELETE FROM Vendor
WHERE name = reqVendorName;

-- Product
DELETE FROM Product
WHERE productID = reqProductID;

DELETE FROM Product
WHERE name = reqProductName;

-- Sells:
DELETE FROM Sells
WHERE vendorID = reqVendorID AND productID = reqProductID;

-- Purchases
DELETE FROM Purchases
WHERE facilityID = reqFacilityID AND productID = reqProductID;

-- Orders
DELETE FROM Orders
WHERE orderID = reqOrderID;