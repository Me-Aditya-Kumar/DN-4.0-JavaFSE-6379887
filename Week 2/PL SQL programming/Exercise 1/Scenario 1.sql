DECLARE
    v_customer_id    Customers.CustomerID%TYPE;
    v_dob            Customers.DOB%TYPE;
    v_age            NUMBER;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_customer_id := cust_rec.CustomerID;
        v_dob := cust_rec.DOB;
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Applied 1% interest discount for CustomerID: ' || v_customer_id);
        END IF;
    END LOOP;
END;
/