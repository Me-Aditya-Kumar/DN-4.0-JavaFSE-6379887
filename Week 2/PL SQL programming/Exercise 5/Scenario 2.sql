CREATE TABLE AuditLog (
    LogID         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    AccountID     NUMBER,
    TransactionID NUMBER,
    Action        VARCHAR2(50),
    LogTime       DATE
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AccountID, TransactionID, Action, LogTime)
    VALUES (:NEW.AccountID, :NEW.TransactionID, 'INSERT', SYSDATE);
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 500, 'Deposit');

SELECT * FROM AuditLog ORDER BY LogID DESC;