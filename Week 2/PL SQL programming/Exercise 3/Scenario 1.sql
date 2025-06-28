CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS v_interest NUMBER;
BEGIN
    FOR acc_rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        v_interest := acc_rec.Balance * 0.01;

        UPDATE Accounts
        SET Balance = Balance + v_interest
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest of ' || v_interest || ' added to Account ID: ' || acc_rec.AccountID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/