CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id     IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary Employees.Salary%TYPE;
BEGIN

    SELECT Salary INTO v_current_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;


    UPDATE Employees
    SET Salary = Salary + (v_current_salary * p_percentage / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID: ' || p_emp_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected Error: ' || SQLERRM);
END;
/

BEGIN
    UpdateSalary(3, 10);  
END;
/

BEGIN
    UpdateSalary(999, 5);  
END;
/
