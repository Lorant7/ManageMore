-- Look at how to add iamges and check if making emplyee ID
-- AUTO_INCREMENT is useful or if we should just generate a random id
-- with JavaScript

-- Figure out what you want for ON UPDATE and ON DELETE

CREATE TABLE Employee(
    employeeID INT UNIQUE,
    name VARCHAR(20),
    job_title VARCHAR(20),
    salary DECIMAL(11,2) NOT NULL DEFAULT 0,
    facilityID INT NOT NULL,
    PRIMARY KEY (employeeID),
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID),
    ON UPDATE CASCADE ON DELETE CASCADE);

CREATE TABLE Facility(
    facilityID INT UNIQUE,
    name VARCHAR(20),
    address VARCHAR(50),
    PRIMARY KEY (facilityID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Transfers(
    start_facilityID INT UNIQUE,
    end_facilityID INT UNIQUE,
    vehicleID INT UNIQUE,
    productID INT,
    PRIMARY KEY (start_facilityID, end_facilityID, vehicleID)
    FOREIGN KEY (start_facilityID) REFERENCES Facility(facilityID),
    FOREIGN KEY (end_facilityID) REFERENCES Facility(facilityID),
    FOREIGN KEY (vehicleID) REFERENCES Vehicle(vehicleID),
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Stock(
    productID INT UNIQUE,
    amount INT DEFAULT 0,
    desired_amount INT DEFAULT 0,
    facilityID INT,
    PRIMARY KEY (productID)
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID),
    ON UPDATE CASCADE ON DELETE CASCADE
);

-- TODO: makeusre driverID instead of driver
CREATE TABLE Vehicle(
    vechicleID INT UNIQUE,
    type VARCHAR(20),
    driverID INT UNIQUE,
    capacity INT DEFAULT 0,
    PRIMARY KEY (vehicleID),
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Vendor(
    vendorID INT UNIQUE,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(50),
    PRIMARY KEY (vendorId),
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Product(
    productID INT UNIQUE,
    name VARCHAR(20),
    description VARCHAR(200),
    image BLOB,
    PRIMARY KEY (productID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Sells(
    vendorID INT UNIQUE,
    productID INT UNIQUE,
    price DECIMAL(7,2)
    PRIMARY KEY (vendorID, productID)
    FOREIGN KEY (vendorID) REFERENCES Vendor(vendorID),
    FOREIGN KEY (productID) REFERENCES Product(productID),
    ON UPDATE CASCADE ON DELETE CASCADE
);

-- Discuss purchases
CREATE TABLE Purchases(
    productID INT UNIQUE,
    amount INT DEFUALT 0,
    vehicleID INT
);