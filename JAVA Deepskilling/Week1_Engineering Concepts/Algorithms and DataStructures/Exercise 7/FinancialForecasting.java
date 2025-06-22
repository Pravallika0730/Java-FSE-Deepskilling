import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    // FV = PV * (1 + r)^n
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return (1 + growthRate) * predictFutureValue(presentValue, growthRate, years - 1);
    }

    // Optimized version using memoization (optional)
    public static double predictFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = (1 + growthRate) * predictFutureValueMemo(presentValue, growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter present value (₹): ");
        double pv = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.08 for 8%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int n = sc.nextInt();

        System.out.println("\n--- Recursive Forecasting ---");
        double futureValue = predictFutureValue(pv, rate, n);
        System.out.printf("Future value after %d years: ₹%.2f%n", n, futureValue);

        System.out.println("\n--- Optimized Forecasting with Memoization ---");
        double[] memo = new double[n + 1];
        double futureValueMemo = predictFutureValueMemo(pv, rate, n, memo);
        System.out.printf("Future value after %d years (memoized): ₹%.2f%n", n, futureValueMemo);

        sc.close();
    }
}
