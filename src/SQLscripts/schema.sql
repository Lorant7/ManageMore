-- Look at how to add iamges and check if making emplyee ID
-- AUTO_INCREMENT is useful or if we should just generate a random id
-- with JavaScript

-- Figure out what you want for ON UPDATE and ON DELETE
-- Make different ON UPDATE and ON DELETE actions for
-- primary and foreign keys

CREATE TABLE Employee(
    employeeID INTEGER UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    salary DECIMAL(11,2) NOT NULL CHECK (salary >= 0),
    facilityID INTEGER NOT NULL,
    PRIMARY KEY (employeeID),
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
    );

CREATE TABLE Facility(
    facilityID INTEGER UNIQUE NOT NULL,
    name VARCHAR(50),
    address VARCHAR(50),
    PRIMARY KEY (facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Stock(
    productID INTEGER NOT NULL,
    amount INTEGER DEFAULT 0 CHECK (amount >= 0) NOT NULL,
    desired_amount INTEGER DEFAULT 0 CHECK (desired_amount >=0) NOT NULL,
    facilityID INTEGER NOT NULL,
    PRIMARY KEY (productID, facilityID)
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Vehicle(
    vehicleID INTEGER UNIQUE NOT NULL,
    type VARCHAR(50),
    driverID INTEGER NOT NULL,
    capacity INTEGER DEFAULT 0 CHECK (capacity >= 0) NOT NULL,
    PRIMARY KEY (vehicleID),
    FOREIGN KEY (driverID) REFERENCES Employee(employeeID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Vendor(
    vendorID INTEGER UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    PRIMARY KEY (vendorId)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Product(
    productID INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(11,2) DEFAULT 0 CHECK (price > 0) NOT NULL,
    description VARCHAR(200),
    image BLOB,
    PRIMARY KEY (productID)
    FOREIGN KEY (vendorID) REFERENCES Vendor(vendorID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Sells(
    vendorID INTEGER NOT NULL,
    productID INTEGER NOT NULL,
    PRIMARY KEY (vendorID, productID),
    FOREIGN KEY (vendorID) REFERENCES Vendor(vendorID),
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Purchases(
    facilityID INTEGER NOT NULL,
    productID INTEGER NOT NULL,
    amount INTEGER DEFUALT 0 CHECK (amount >= 0) NOT NULL,
    unitPrice DECIMAL(7,2) DEFAULT 0 CHECK (unitPrice > 0) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY(facilityID, porductID),
    FOREIGN KEY (facilityID) REFERENCES Facility(facilityID),
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- I set the name as Orders because Order is a key word
CREATE TABLE Orders(
    orderID INTEGER UNIQUE NOT NULL,
    productID INTEGER NOT NULL,
    amount INTEGER DEFAULT 0 CHECK (amount > 0) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (orderID)
    FOREIGN KEY (productID) REFERENCES Product(productID)
        ON UPDATE CASCADE ON DELETE CASCADE
)