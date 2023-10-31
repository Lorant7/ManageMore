-- Get the vendor from which we have paied the most
SELECT MAX(Purchases.amount * Purchases.unitPrice) AS max_purchase_value, Vendor.*
FROM Vendor NATURAL JOIN Sells NATURAL JOIN Purchases
GROUP BY Vendor.vendorID;