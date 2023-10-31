
-- Move stock from one facility to the other, then delete facility
BEGIN TRANSACTION;

UPDATE Stock
SET facilityID = newFacilityID
WHERE facilityID = oldFacilityID;

-- Check with Java if the Stock was transfered, if it wasn't ROLLBACK

DELETE FROM Facility
WHERE facilityID = oldFacilityID;

COMMIT;
