public class FinancialForecasting {

    // Recursive approach to calculate future value
    public static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized approach using formula (iterative)
    public static double forecastOptimized(double initialValue, double growthRate, int years) {
        return initialValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000;  // initial amount
        double annualGrowthRate = 0.08;    // 8% annual growth
        int years = 5;

        // Recursive forecast
        double futureValueRecursive = forecastRecursive(initialInvestment, annualGrowthRate, years);
        System.out.printf("Recursive Forecast (Year %d): ₹%.2f\n", years, futureValueRecursive);

        // Optimized forecast
        double futureValueOptimized = forecastOptimized(initialInvestment, annualGrowthRate, years);
        System.out.printf("Optimized Forecast (Year %d): ₹%.2f\n", years, futureValueOptimized);
    }
}
