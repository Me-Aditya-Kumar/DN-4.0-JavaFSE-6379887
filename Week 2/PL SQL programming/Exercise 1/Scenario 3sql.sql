DECLARE
    v_days_left NUMBER;
BEGIN
    FOR loan_rec IN (
        SELECT L.LoanID, L.CustomerID, L.EndDate, C.Name
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.EndDate <= SYSDATE + 30
    ) LOOP
        v_days_left := loan_rec.EndDate - SYSDATE;

        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID ||
                             ' for customer "' || loan_rec.Name ||
                             '" is due in ' || v_days_left || ' days.');
    END LOOP;
END;
/