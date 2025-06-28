CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

SELECT CustomerID, LastModified
FROM Customers
WHERE CustomerID = 1;