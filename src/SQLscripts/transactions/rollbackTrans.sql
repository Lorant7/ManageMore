BEGIN TRANSACTION;

INSERT INTO Employee (employeeID, name, job_title, salary, facilityID)
VALUES (7, 'James Bond', 'Manager', -20, 3);

SELECT CASE
    WHEN (SELECT salary FROM Employee WHERE employeeID = 7) < 0 THEN ROLLBACK
END;

COMMIT;
