-- View employees of a certain facility
-- reqFacility is the facility requested
SELECT E.employeeID, E.name, E.job_title, E.salary, E.employee_type
FROM Employee AS E
WHERE E.facilityID = reqFacility;

-- View employees of a certain type in a 
-- certain facility
SELECT E.employeeID, E.name, E.job_title, E.salary
FROM Employee AS E
WHERE E.facility = reqFacility AND E.employee_type = reqEmployeeType;

-- View stock of a facility
-- reqFacility is the facility requested
SELECT S.productID, S.amount, S.desired_mount
FROM Stock AS S
WHERE S.facilityID = reqFacility;

-- Get number of employees in facility
SELECT COUNT E.employeeID
FROM Employee AS E
WHERE E.facilityID = reqFacility;

-- Get total of a certain product in all facilites
SELECT COUNT S.productID
FROM Facility AS F
NATURAL JOIN Stock AS S;

-- TODO: is there anything else we want to check
-- with facilities?

-- Get the company, product ID, and the price of the
-- the prodcut ID with the lowest/highest value



-- Vendors:

-- Get the products that a vendor sends
SELECT P*
FROM Product AS P NATURAL JOIN Sells AS S
WHERE S.vendorID = reqVendorID;

-- Get the vendors who sell a certain product
-- TODO: should I change this to P.name = reqName?
SELECT V*, P.price
FROM Vendor AS V NATURAL JOIN Sells AS S NATURAL JOIN Product AS P
WHERE S.productID = reqProductID;





