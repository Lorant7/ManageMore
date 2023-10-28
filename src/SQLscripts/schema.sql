-- Look at how to add iamges and check if making emplyee ID
-- AUTO_INCREMENT is useful or if we should just generate a random id
-- with JavaScript

-- Figure out what you want for ON UPDATE and ON DELETE
-- Make different ON UPDATE and ON DELETE actions for
-- primary and foreign keys

CREATE TABLE Employee(
    employeeID INTEGER UNIQUE,
    name VARCHAR(50),
    job_title VARCHAR(50),
    salary DECIMAL(11,2) NOT NULL DEFAULT 0,
    facilityID INTEGER NOT NULL,
    employee_type VARCHAR(50),
    PRIMARY KEY (employeeID),
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
    );

CREATE TABLE Facility(
    facilityID INTEGER UNIQUE,
    name VARCHAR(50),
    address VARCHAR(50),
    PRIMARY KEY (facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Stock(
    productID INTEGER,
    amount INTEGER DEFAULT 0,
    desired_amount INTEGER DEFAULT 0,
    facilityID INTEGER,
    PRIMARY KEY (productID, facilityID)
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- TODO: makeusre driverID instead of driver
CREATE TABLE Vehicle(
    vechicleID INTEGER UNIQUE,
    type VARCHAR(50),
    driverID INTEGER UNIQUE,
    capacity INTEGER DEFAULT 0,
    PRIMARY KEY (vehicleID),
    FOREIGN KEY (driverID) REFERENCES Employee(employeeID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Vendor(
    vendorID INTEGER UNIQUE,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    PRIMARY KEY (vendorId)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Product(
    productID INTEGER NOT NULL,
    vendorID INTEGER NOT NULL,
    name VARCHAR(50),
    price INTEGER DEFAULT 0,
    description VARCHAR(200),
    image BLOB,
    PRIMARY KEY (productID)
    FOREIGN KEY (vendorID) REFERENCES Vendor(vendorID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Sells(
    vendorID INTEGER NOT NULL,
    productID INTEGER NOT NULL,
    price DECIMAL(7,2) DEFAULT 0,
    PRIMARY KEY (vendorID, productID),
    FOREIGN KEY (vendorID) REFERENCES Vendor(vendorID),
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Discuss purchases
CREATE TABLE Purchases(
    facilityID INTEGER NOT NULL,
    productID INTEGER NOT NULL,
    amount INTEGER DEFUALT 0,
    unitPrice DECIMAL(7,2) DEFAULT 0,
    PRIMARY KEY(facilityID, porductID),
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID),
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Order(
    orderID INTEGER UNIQUE,
    productID INTEGER NOT NULL,
    amount INTEGER DEFAULT 0,
    PRIMARY KEY (orderID)
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
)