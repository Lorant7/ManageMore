-- Insert companies
INSERT INTO Facility (facilityID, name, address) VALUES
(1, 'Warehouse A', '123 Main St, City1, Country'),
(2, 'Distribution Center B', '456 Oak St, City2, Country'),
(3, 'Storage Facility C', '789 Pine St, City3, Country'),
(4, 'Logistics Hub D', '101 Elm St, City4, Country');

-- Insert data into Stock table with flipped values
INSERT INTO Stock (productID, amount, desired_amount, facilityID) VALUES
-- Facility 1
(1, 60, 50, 1),
(2, 40, 30, 1),
(3, 15, 25, 1),
(4, 15, 10, 1),
(5, 20, 15, 1),
(6, 25, 20, 1),
(7, 50, 40, 1),
(8, 10, 5, 1),
(9, 60, 50, 1),
(10, 120, 100, 1),
-- Facility 2
(11, 15, 10, 2),
(12, 20, 15, 2),
(13, 29, 30, 2),
(14, 35, 25, 2),
(15, 20, 15, 2),
(16, 25, 20, 2),
(17, 10, 5, 2),
(18, 45, 35, 2),
(19, 15, 10, 2),
(20, 40, 50, 2),
-- Facility 3
(1, 50, 40, 3),
(2, 25, 20, 3),
(3, 30, 25, 3),
(4, 20, 15, 3),
(5, 30, 25, 3),
(6, 35, 30, 3),
(7, 25, 20, 3),
(8, 15, 10, 3),
(9, 50, 60, 3),
(10, 10, 80, 3),
-- Facility 4
(11, 20, 15, 4),
(12, 30, 25, 4),
(13, 25, 20, 4),
(14, 40, 30, 4),
(15, 50, 40, 4),
(16, 15, 10, 4),
(17, 25, 35, 4),
(18, 20, 15, 4),
(19, 30, 25, 4),
(20, 55, 45, 4);


INSERT INTO Vendor (vendorID, name, address) VALUES
(1, 'Electronics Supplier Inc.', '789 Supplier Ave, City5, Country'),
(2, 'Furniture Wholesalers Co.', '456 Wholesaler St, City6, Country'),
(3, 'Clothing Manufacturers Ltd.', '101 Garment Blvd, City7, Country'),
(4, 'Food Distributors Corp.', '222 Grocery Lane, City8, Country'),
(5, 'Medical Supplies Ltd.', '333 Health St, City9, Country'),
(6, 'Auto Parts Depot', '444 Automotive Ave, City10, Country'),
(7, 'Sports Equipment Inc.', '555 Sports St, City11, Country'),
(8, 'Home Decor Suppliers', '666 Decor Dr, City12, Country'),
(9, 'Beauty Products Co.', '777 Beauty Ave, City13, Country'),
(10, 'Stationery Supplies Ltd.', '888 Paper St, City14, Country');

-- Insert employees
INSERT INTO Employee (employeeID, name, job_title, salary) VALUES
(1, 'John Doe', 'Manager', 60000.00),
(2, 'Alice Johnson', 'Driver', 35000.00),
(3, 'Bob Smith', 'Manager', 55000.00),
(4, 'Cathy Martin', 'Inventory Control Specialist', 40000.00),
(5, 'David Williams', 'Manager', 60000.00),
(6, 'Eva Davis', 'Inventory Specialist', 50000.00),
(7, 'Frank Miller', 'Forklift Operator', 65000.00),
(8, 'Grace Taylor', 'Manager', 45000.00),
(9, 'Henry Brown', 'Driver', 55000.00),
(10, 'Ivy Moore', 'Manager', 40000.00),
(11, 'Jack Anderson', 'Driver', 70000.00),
(12, 'Karen Wilson', 'Manager', 36000.00),
(13, 'Leo Thomas', 'Inventory Specialist', 58000.00),
(14, 'Mia Martinez', 'Manager', 42000.00),
(15, 'Nick White', 'Forklift Operator', 65000.00),
(16, 'Olivia Clark', 'Manager', 52000.00),
(17, 'Paula Adams', 'Driver', 48000.00),
(18, 'Quentin Turner', 'Manager', 53000.00),
(19, 'Rachel Garcia', 'Inventory Control Specialist', 47000.00),
(20, 'Samuel Rodriguez', 'Manager', 49000.00),
(21, 'Tina Mitchell', 'Driver', 51000.00),
(22, 'Ulysses Scott', 'Manager', 39000.00),
(23, 'Vivian Lee', 'Inventory Specialist', 62000.00),
(24, 'Walter Hernandez', 'Manager', 68000.00),
(25, 'Ximena Flores', 'Forklift Operator', 60000.00),
(26, 'Yasmine Young', 'Manager', 43000.00),
(27, 'Zachary Turner', 'Inventory Control Specialist', 57000.00),
(28, 'Abigail Powell', 'Manager', 48000.00),
(29, 'Benjamin Cox', 'Forklift Operator', 49000.00),
(30, 'Caroline King', 'Manager', 70000.00),
(31, 'Daniel Reed', 'Driver', 36000.00),
(32, 'Emily Brown', 'Manager', 42000.00),
(33, 'Felix Taylor', 'Inventory Specialist', 55000.00),
(34, 'Giselle Wright', 'Manager', 38000.00),
(35, 'Harold Martinez', 'Forklift Operator', 58000.00),
(36, 'Isabel Evans', 'Manager', 65000.00),
(37, 'Jacob Adams', 'Driver', 67000.00),
(38, 'Katherine Perry', 'Manager', 44000.00),
(39, 'Lucas Turner', 'Forklift Operator', 48000.00),
(40, 'Megan Foster', 'Manager', 51000.00),
(41, 'Nathan Rodriguez', 'Inventory Specialist', 47000.00),
(42, 'Olivia Turner', 'Manager', 70000.00),
(43, 'Peter Harris', 'Forklift Operator', 40000.00),
(44, 'Quinn Mitchell', 'Manager', 60000.00),
(45, 'Rebecca Flores', 'Inventory Control Specialist', 52000.00),
(46, 'Simon Turner', 'Manager', 68000.00),
(47, 'Tanya White', 'Forklift Operator', 54000.00),
(48, 'Ulysses Scott', 'Manager', 58000.00),
(49, 'Victoria Turner', 'Inventory Specialist', 65000.00),
(50, 'William Anderson', 'Manager', 49000.00);


-- Insert drivers
INSERT INTO Driver (driverID, vehicleID) VALUES
(2, 1),
(9, 2),
(11, 3),
(17, 4),
(21, 5),
(29, 6),
(31, 7),
(37, 8),
(39, 9),
(43, 10),
(41, 11),
(47, 12),
(49, 13),
(50, 14);


-- Insert facility employees (non-drivers)
INSERT INTO FacilityEmployee (employeeID, facilityID, position) VALUES
(1, 1, 'Manager'),  -- John Doe - Facility 1
(3, 2, 'Manager'),  -- Bob Smith - Facility 2
(5, 3, 'Manager'),  -- David Williams - Facility 3
(6, 4, 'Inventory Specialist'),  -- Eva Davis - Facility 4
(7, 1, 'Forklift Operator'),  -- Frank Miller - Facility 1
(8, 2, 'Manager'),  -- Grace Taylor - Facility 2
(10, 3, 'Manager'),  -- Ivy Moore - Facility 3
(13, 4, 'Inventory Specialist'),  -- Leo Thomas - Facility 4
(14, 1, 'Manager'),  -- Mia Martinez - Facility 1
(16, 2, 'Manager'),  -- Olivia Clark - Facility 2
(18, 3, 'Inventory Specialist'),  -- Quentin Turner - Facility 3
(20, 4, 'Manager'),  -- Samuel Rodriguez - Facility 4
(22, 1, 'Manager'),  -- Ulysses Scott - Facility 1
(23, 2, 'Inventory Specialist'),  -- Vivian Lee - Facility 2
(25, 3, 'Forklift Operator'),  -- Ximena Flores - Facility 3
(26, 4, 'Manager'),  -- Yasmine Young - Facility 4
(28, 1, 'Manager'),  -- Abigail Powell - Facility 1
(30, 2, 'Manager'),  -- Caroline King - Facility 2
(32, 3, 'Forklift Operator'),  -- Emily Brown - Facility 3
(33, 4, 'Inventory Specialist'),  -- Felix Taylor - Facility 4
(35, 1, 'Manager'),  -- Harold Martinez - Facility 1
(36, 2, 'Manager'),  -- Isabel Evans - Facility 2
(38, 3, 'Forklift Operator'),  -- Katherine Perry - Facility 3
(40, 4, 'Manager'),  -- Megan Foster - Facility 4
(41, 1, 'Inventory Specialist'),  -- Nathan Rodriguez - Facility 1
(44, 2, 'Manager'),  -- Quinn Mitchell - Facility 2
(45, 3, 'Forklift Operator'),  -- Rebecca Flores - Facility 3
(48, 4, 'Manager');  -- Ulysses Scott - Facility 4


-- Insert vehicles
INSERT INTO Vehicle (vehicleID, type, driverID, capacity) VALUES
(1, 'Truck', 2, 100),  -- Assigned to Alice Johnson
(2, 'Van', 9, 50),  -- Assigned to Henry Brown
(3, 'Truck', 11, 120),  -- Assigned to Jack Anderson
(4, 'Van', 17, 60),  -- Assigned to Paula Adams
(5, 'Truck', 21, 110),  -- Assigned to Tina Mitchell
(6, 'Van', 29, 55),  -- Assigned to Daniel Reed
(7, 'Truck', 31, 105),  -- Assigned to Jacob Adams
(8, 'Van', 37, 65),  -- Assigned to Olivia Turner
(9, 'Truck', 39, 95),  -- Assigned to Peter Harris
(10, 'Van', 43, 45),  -- Assigned to Quinn Mitchell
(11, 'Truck', 41, 100),  -- Assigned to Nathan Rodriguez
(12, 'Van', 47, 75),  -- Assigned to Tanya White
(13, 'Truck', 49, 90),  -- Assigned to Victoria Turner
(14, 'Van', 50, 70);  -- Assigned to William Anderson


-- Insert data into Sells table
INSERT INTO Sells (vendorID, productID) VALUES
(1, 1),  -- Vendor 1 sells Laptop
(2, 2),  -- Vendor 2 sells Smartphone
(3, 3),  -- Vendor 3 sells Desk Chair
(4, 4),  -- Vendor 4 sells LED TV
(5, 5),  -- Vendor 5 sells Refrigerator
(6, 6),  -- Vendor 6 sells Gaming Console
(7, 7),  -- Vendor 7 sells Sports Shoes
(8, 8),  -- Vendor 8 sells Home Decor Set
(9, 9),  -- Vendor 9 sells Beauty Kit
(10, 10),  -- Vendor 10 sells Stationery Bundle
(1, 11),  -- Vendor 1 sells Coffee Maker
(2, 12),  -- Vendor 2 sells Bluetooth Speaker
(3, 13),  -- Vendor 3 sells Desk Lamp
(4, 14),  -- Vendor 4 sells Cookware Set
(5, 15),  -- Vendor 5 sells Fitness Tracker
(6, 16),  -- Vendor 6 sells Backpack
(7, 17),  -- Vendor 7 sells Digital Camera
(8, 18),  -- Vendor 8 sells Bluetooth Earbuds
(9, 19),  -- Vendor 9 sells Vacuum Cleaner
(10, 20),  -- Vendor 10 sells Portable Charger
(1, 1),  -- Vendor 1 sells Laptop (duplicate entry for limited overlap)
(2, 2),  -- Vendor 2 sells Smartphone (duplicate entry for limited overlap)
(3, 3),  -- Vendor 3 sells Desk Chair (duplicate entry for limited overlap)
(4, 4),  -- Vendor 4 sells LED TV (duplicate entry for limited overlap)
(5, 5),  -- Vendor 5 sells Refrigerator (duplicate entry for limited overlap)
(6, 6),  -- Vendor 6 sells Gaming Console (duplicate entry for limited overlap)
(7, 7),  -- Vendor 7 sells Sports Shoes (duplicate entry for limited overlap)
(8, 8),  -- Vendor 8 sells Home Decor Set (duplicate entry for limited overlap)
(9, 9);  -- Vendor 9 sells Beauty Kit (duplicate entry for limited overlap)


-- Insert products
INSERT INTO Product (productID, name, price, description, vendorID, image) VALUES
(1, 'Laptop', 1200.00, 'Powerful laptop with high-end specifications.', 1, 0x[SELECT HEX(image_data) FROM your_table WHERE condition]),
(2, 'Smartphone', 800.00, 'Latest model with advanced features.', 2),
(3, 'Desk Chair', 150.00, 'Ergonomic office chair for comfort.', 3),
(4, 'LED TV', 700.00, 'Ultra HD Smart TV with a large display.', 4),
(5, 'Refrigerator', 900.00, 'Energy-efficient refrigerator with ample storage.', 5),
(6, 'Gaming Console', 400.00, 'Popular gaming console with a vast game library.', 6),
(7, 'Sports Shoes', 80.00, 'Comfortable athletic shoes for various sports.', 7),
(8, 'Home Decor Set', 200.00, 'A set of stylish home decor items.', 8),
(9, 'Beauty Kit', 50.00, 'Complete beauty kit for skincare and makeup.', 9),
(10, 'Stationery Bundle', 30.00, 'Essential stationery items for work or school.', 10),
(11, 'Coffee Maker', 60.00, 'Automatic coffee maker for brewing delicious coffee.', 1),
(12, 'Bluetooth Speaker', 40.00, 'Portable speaker with wireless connectivity.', 2),
(13, 'Desk Lamp', 25.00, 'Adjustable desk lamp for focused lighting.', 3),
(14, 'Cookware Set', 100.00, 'High-quality cookware set for the kitchen.', 4),
(15, 'Fitness Tracker', 50.00, 'Wearable device to monitor fitness activities.', 5),
(16, 'Backpack', 35.00, 'Durable backpack for daily use or travel.', 6),
(17, 'Digital Camera', 300.00, 'Compact digital camera for capturing memories.', 7),
(18, 'Bluetooth Earbuds', 30.00, 'Wireless earbuds for on-the-go audio.', 8),
(19, 'Vacuum Cleaner', 80.00, 'Efficient vacuum cleaner for household cleaning.', 9),
(20, 'Portable Charger', 20.00, 'Compact power bank for charging devices on the go.', 10);


-- Insert purchases
INSERT INTO Purchases (facilityID, productID, amount, unitPrice, date) VALUES
(1, 1, 50, 1000.00, '2023-01-10'),
(2, 2, 30, 700.00, '2023-01-12'),
(3, 3, 25, 120.00, '2023-01-15'),
(4, 4, 10, 600.00, '2023-01-18'),
(1, 5, 15, 800.00, '2023-01-20'),
(2, 6, 20, 350.00, '2023-01-22'),
(3, 7, 40, 60.00, '2023-01-25'),
(4, 8, 5, 180.00, '2023-01-28'),
(1, 9, 50, 25.00, '2023-02-01'),
(2, 10, 100, 10.00, '2023-02-05'),
(3, 11, 10, 50.00, '2023-02-10'),
(4, 12, 15, 30.00, '2023-02-15'),
(1, 13, 30, 90.00, '2023-02-20'),
(2, 14, 25, 150.00, '2023-02-25'),
(3, 15, 15, 40.00, '2023-03-01'),
(4, 16, 20, 20.00, '2023-03-05'),
(1, 17, 10, 250.00, '2023-03-10'),
(2, 18, 35, 15.00, '2023-03-15'),
(3, 19, 5, 70.00, '2023-03-20'),
(4, 20, 50, 12.00, '2023-03-25');


-- Insert orders
INSERT INTO Orders (orderID, productID, amount, date) VALUES
(1, 1, 10, '2023-01-05'),
(2, 2, 5, '2023-01-07'),
(3, 3, 8, '2023-01-10'),
(4, 4, 15, '2023-01-12'),
(5, 5, 12, '2023-01-15'),
(6, 6, 20, '2023-01-18'),
(7, 7, 25, '2023-01-20'),
(8, 8, 30, '2023-01-22'),
(9, 9, 7, '2023-01-25'),
(10, 10, 15, '2023-01-28'),
(11, 11, 10, '2023-02-01'),
(12, 12, 18, '2023-02-05'),
(13, 13, 22, '2023-02-10'),
(14, 14, 14, '2023-02-15'),
(15, 15, 25, '2023-02-20'),
(16, 16, 30, '2023-02-25'),
(17, 17, 5, '2023-03-01'),
(18, 18, 12, '2023-03-05'),
(19, 19, 18, '2023-03-10'),
(20, 20, 20, '2023-03-15'),
(21, 1, 15, '2023-03-20'),
(22, 2, 8, '2023-03-25'),
(23, 3, 25, '2023-03-30'),
(24, 4, 10, '2023-04-05'),
(25, 5, 12, '2023-04-10'),
(26, 6, 20, '2023-04-15'),
(27, 7, 10, '2023-04-20'),
(28, 8, 15, '2023-04-25'),
(29, 9, 5, '2023-04-30'),
(30, 10, 18, '2023-05-05');

