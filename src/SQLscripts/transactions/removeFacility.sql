-- TODO: should I move all of the stock to another facility?
DELETE FROM Stock
WHERE facilityID = reqFacilityID;

DELETE FROM Facility
WHERE facilityID = reqFacilityID;