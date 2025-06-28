CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_emp_id    IN NUMBER,
        p_name      IN VARCHAR2,
        p_position  IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept      IN VARCHAR2,
        p_hiredate  IN DATE
    );

    PROCEDURE UpdateEmployee (
        p_emp_id    IN NUMBER,
        p_name      IN VARCHAR2,
        p_salary    IN NUMBER
    );

    FUNCTION CalculateAnnualSalary (
        p_emp_id    IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_emp_id    IN NUMBER,
        p_name      IN VARCHAR2,
        p_position  IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept      IN VARCHAR2,
        p_hiredate  IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_emp_id, p_name, p_position, p_salary, p_dept, p_hiredate);

        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    PROCEDURE UpdateEmployee (
        p_emp_id IN NUMBER,
        p_name   IN VARCHAR2,
        p_salary IN NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Salary = p_salary
        WHERE EmployeeID = p_emp_id;

        DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_name);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    FUNCTION CalculateAnnualSalary (
        p_emp_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_emp_id;

        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
        WHEN OTHERS THEN
            RETURN NULL;
    END;

END EmployeeManagement;
/

BEGIN
    EmployeeManagement.HireEmployee(10, 'Ravi Kumar', 'Analyst', 40000, 'Finance', SYSDATE);
    EmployeeManagement.UpdateEmployee(10, 'Ravi K.', 45000);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || EmployeeManagement.CalculateAnnualSalary(10));
END;
/