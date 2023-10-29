-- TODO: should I move all of the stock to another facility?
DELETE FROM Facility
WHERE facilityID = reqFacilityID 
AND facilityID NOT IN(
    SELECT facilityID
    FROM Stock
    );