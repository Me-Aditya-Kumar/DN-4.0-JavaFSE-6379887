DECLARE
    CURSOR cur_monthly_txns IS
        SELECT C.Name AS CustomerName,
               T.AccountID,
               T.TransactionDate,
               T.Amount,
               T.TransactionType
        FROM Transactions T
        JOIN Accounts A ON T.AccountID = A.AccountID
        JOIN Customers C ON A.CustomerID = C.CustomerID
        WHERE TRUNC(T.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');

    v_record cur_monthly_txns%ROWTYPE;
BEGIN
    OPEN cur_monthly_txns;
    LOOP
        FETCH cur_monthly_txns INTO v_record;
        EXIT WHEN cur_monthly_txns%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Monthly Statement');
        DBMS_OUTPUT.PUT_LINE('Customer  : ' || v_record.CustomerName);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_record.AccountID);
        DBMS_OUTPUT.PUT_LINE('Date      : ' || TO_CHAR(v_record.TransactionDate, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Type      : ' || v_record.TransactionType);
        DBMS_OUTPUT.PUT_LINE('Amount    : ₹' || v_record.Amount);
        DBMS_OUTPUT.PUT_LINE('-----------------------------');
    END LOOP;
    CLOSE cur_monthly_txns;
END;
/