-- COALESCE returns the first non-NULL value in the give list
UPDATE Employee
SET name = COALESCE(givenName, name), job_title = COALESCE(givenJobTitle, job_title), salary = COALESCE(givenSalary, salary)
WHERE emplyeeID = givenEmployeeID;

UPDATE Driver
SET vehicleID = givenVehicleID
WHERE driverID = oldDriverID;

UPDATE FacilityEmployee
SET facilityID = COALESCE(newFacilityID, facilityID), position = COALESCE(newPosition, position)
WHERE employeeID = givenEmployeeID;

UPDATE Facility
SET name = COALESCE(givenName, name), address = COALESCE(givenAddress, address)
WHERE facilityID = givenFacilityID;

UPDATE Stock
SET amount = COALESCE(givenAmount, amount), desired_amount = COALESCE(givenDesiredAmount, desired_amount)
WHERE productID = givenProductID AND facilityID = givenFacilityID;

UPDATE Vehicle
SET type = COALESCE(givenType, type), driverID = COALESCE(givenDriverID, driverID), capacity = COALESCE(givenCapacity, capacity)
WHERE vehicleID = givenVehicleID;

UPDATE Vendor
SET name = COALESCE(givenName, name), address = COALESCE(givenAddress, addres)
WHERE vendorID = givenVendorID;

UPDATE Product
SET name = COALESCE(givenName, name), price = COALESCE(givenPrice, price), description = COALESCE(givenDescription, description), image = COALESCE(givenImage, image)
WHERE productID = givenProductID;

UPDATE Purchases
SET amount = COALSECE(givenAmount, amount), unitPrice = COALESCE(givenUnitPrice, unitPrice), date = COALESCE(givenDate, date)
WHERE facilityID = givenFacilitID AND productID = givenProductID AND date = givenDate;

UPDATE Orders
SET amount = COALESCE(newAmount, amount), date = COALESCE(newDate,date)
WHERE orderID = givenOrderID;