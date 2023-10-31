-- All the information of all the drivers that had an orderd picked up at a given facility
-- after some date. (This can be used in case something goes wrong and we want to keep track of
-- who was present in that incident).
SELECT Employee.*
FROM Employee NATURAL JOIN Driver NATURAL JOIN Vehicle NATURAL JOIN Orders NATURAL JOIN Stock
WHERE Orders.date >= givenDate AND Stock.facilityID = reqFacilityID;