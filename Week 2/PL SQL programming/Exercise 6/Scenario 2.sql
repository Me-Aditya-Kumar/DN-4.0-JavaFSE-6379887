DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account cur_accounts%ROWTYPE;
    v_fee CONSTANT NUMBER := 200;
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_account;
        EXIT WHEN cur_accounts%NOTFOUND;
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_account.AccountID;

        DBMS_OUTPUT.PUT_LINE(' ' || v_fee || 
                             ' annual fee deducted from Account ID: ' || v_account.AccountID);
    END LOOP;
    CLOSE cur_accounts;

    COMMIT;
END;
/