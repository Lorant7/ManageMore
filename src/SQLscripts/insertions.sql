INSERT INTO Employee
VALUES (assignedEmployeeID, givenName, givenJobTitle, givenSalary);

INSERT INTO Driver
VALUES (assignedDriverID, givenVehicleID);

INSERT INTO Driver (driverID)
VALUES (assignedDriverID);

INSERT INTO FacilityEmployee
VALUES (employeeID, facilityID, position);

INSERT INTO Facility
VALUES (assignedFacilityID, givenName, givenAddress);

INSERT INTO Facility (facilityID, name)
VALUES (assignedFacilityID, givenName);

INSERT INTO Facility (facilityId, address)
VALUES (assignedFacilityID, givenAddress);

INSERT INTO Facility (facilityId)
VALUES (assignedFacilityID);

INSERT INTO Stock
VALUES (givenProductID, givenAmount, givenDesiredAmount, givenFacilityID);

INSERT INTO Vehicle
VALUES (assignedVehicleID, givenType, givenDriverID, givenCapacity);

INSERT INTO Vehicle (type, driverID, capacity)
VALUES (givenType, givenDriverID, givenCapacity);

INSERT INTO Vendor
VALUES (givenVendorID, givenName, givenAddress);

INSERT INTO Product
VALUES (assignedProductID, givenName, givenPrice, givenDescription, givenImage);

INSERT INTO Product (productID, name, price, description)
VALUES (assignedProductID, givenName, givenPrice, givenDescription);

INSERT INTO Product (productID, name, price, image)
VALUES (assignedProductID, givenName, givenPrice, givenImage);

INSERT INTO Product (productID, name, price)
VALUES (assignedProductID, givenName, givenPrice);

INSERT INTO Sells
VALUES (assignedVendorID, assignedProductID);

INSERT INTO Purchases
VALUES (assignedFacilityID, assignedProdductID, givenAmount, givenUnitPrice, givenDate);

INSERT INTO Orders
VALUES (assignedOrderID, givenProductID, givenAmount, givenDate);