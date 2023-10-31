-- Order vendors by most sold
SELECT Vendor.*
FROM Vendor NATURAL JOIN Sells NATURAL JOIN Purchases
GROUP BY Vendor.vendorID
ORDER BY SUM(Purchases.amount*Purchases.unitPrice);