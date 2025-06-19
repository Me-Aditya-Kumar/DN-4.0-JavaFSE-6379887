public class FinancialForecast {

    public static double futureValueRecursive(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValueRecursive(principal, rate, years - 1) * (1 + rate);
    }
    public static double futureValueIterative(double principal, double rate, int years) {
        double futureValue = principal;
        for (int i = 1; i <= years; i++) {
            futureValue *= (1 + rate);
        }
        return futureValue;
    }

    public static double futureValueFormula(double principal, double rate, int years) {
        return principal * Math.pow(1 + rate, years);
    }

    public static void main(String[] args) {
        double principal = 10000.0; 
        double rate = 0.08;         
        int years = 5;              

        double recursiveResult = futureValueRecursive(principal, rate, years);
        double iterativeResult = futureValueIterative(principal, rate, years);
        double formulaResult   = futureValueFormula(principal, rate, years);

        System.out.printf("Future Value (Recursive): Rs %.2f%n", recursiveResult);
        System.out.printf("Future Value (Iterative): Rs %.2f%n", iterativeResult);
        System.out.printf("Future Value (Formula)  : Rs %.2f%n", formulaResult);
    }
}
