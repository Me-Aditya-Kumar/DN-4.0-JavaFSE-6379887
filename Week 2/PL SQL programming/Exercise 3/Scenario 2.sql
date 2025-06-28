CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
) AS
    v_new_salary NUMBER;
BEGIN
    FOR emp_rec IN (
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        v_new_salary := emp_rec.Salary + (emp_rec.Salary * p_bonus_pct / 100);

        UPDATE Employees
        SET Salary = v_new_salary
        WHERE EmployeeID = emp_rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied: ' || emp_rec.Name || ' | New Salary: ' || v_new_salary);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/