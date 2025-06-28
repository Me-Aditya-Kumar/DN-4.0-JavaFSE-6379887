DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

    v_loan cur_loans%ROWTYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loan;
        EXIT WHEN cur_loans%NOTFOUND;

        IF v_loan.LoanAmount > 10000 THEN
            v_new_rate := v_loan.InterestRate + 0.5;
        ELSE
            v_new_rate := v_loan.InterestRate - 0.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan.LoanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan.LoanID ||
                             ' updated from ' || v_loan.InterestRate || '% to ' || v_new_rate || '%.');
    END LOOP;
    CLOSE cur_loans;

    COMMIT;
END;
/
