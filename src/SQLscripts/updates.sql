-- COALESCE returns the first non-NULL value in the give list
UPDATE Employee
SET name = COALESCE(givenName, name), job_title = COALESCE(givenJobTitle, job_title), salary = COALESCE(givenSalary, salary), facilityID = COALESCE(givenFacilityID,facilityID)
WHERE emplyeeID = givenEmployeeID;

UPDATE Facility
SET name = COALESCE(givenName, name), address = COALESCE(givenAddress, address)
WHERE facilityID = givenFacilityID;

UPDATE Stock
SET amount = COALESCE(givenAmount, amount), desired_amount = COALESCE(givenDesiredAmount, desired_amount)
WHERE productID = givenProductID AND facilityID = givenFacilityID;

UPDATE Vehicle
SET type = COALESCE(givenType, type), dirverID = COALESCE(givenDriverID, driverID), capacity = COALESCE(givenCapacity, capacity)
WHERE vehicleID = givenVehicleID;

UPDATE Vendor
SET name = COALESCE(givenName, name), address = COALESCE(givenAddress, addres)
WHERE vendorID = givenVendorID;

UPDATE Product
SET name = COALESCE(givenName, name), price = COALESCE(givenPrice, price), description = COALESCE(givenDescription, description), image = COALESCE(givenImage, image)
WHERE productID = givenProductID;

-- Probably won't need this because it is a table with the products sold
-- from one vendor to 
-- UPDATE sells

UPDATE Purchases
SET amount = COALSECE(givenAmount, amount), unitPrice = COALESCE(givenUnitPrice, unitPrice), date = COALESCE(givenDate, date)
WHERE facilityID = givenFacilitID AND productID = givenProductID;