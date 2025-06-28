CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_amount        IN NUMBER,
    p_annual_rate   IN NUMBER,
    p_years         IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / 12 / 100;
    v_months := p_years * 12;
    v_emi := (p_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) /
             (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        RETURN 0;
    WHEN OTHERS THEN
        RETURN NULL;
END;
/

SELECT CalculateMonthlyInstallment(10000, 6, 2) AS EMI FROM DUAL;
