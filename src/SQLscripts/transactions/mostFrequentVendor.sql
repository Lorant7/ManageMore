-- Get the vendor from which we have purchased the most products
SELECT MAX(Purchases.amount * Purchases.unitPrice) AS max_purchase_value, Vendor.*
FROM Vendor NATURAL JOIN Product NATURAL JOIN Purchases
GROUP BY Vendor.vendorID;