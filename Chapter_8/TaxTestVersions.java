//TaxTestVersions.java

import java.util.*;
class TaxCalculatorV5 {
    Map<String, Object> taxReturn;
    double totalIncome;

    double getTax(Map<String, Object> taxReturn) {
        this.taxReturn = taxReturn;
        double tax = determineBaseTax();
        tax += new BadBobAdjuster(this).getAdjustment();
        return tax;
    }

    double determineBaseTax() {
        totalIncome = (int) ((Map<String, Object>) taxReturn.get("income")).get("salary");
        double tax = totalIncome * 0.15;
        double afterTaxIncome = totalIncome - tax;
        if (afterTaxIncome < 30000) {
            tax = totalIncome - 30000;
        }
        return tax;
    }
}

class BadBobAdjuster {
    private TaxCalculatorV5 taxCalculator;

    // Data-driven table: {threshold, rate} pairs
    // Use Double.MAX_VALUE to represent "max" (the book's "max" string)
    private final double[][] class2Table = {
        {1001, 0},
        {10001, 0.05},
        {50001, 0.1},
        {Double.MAX_VALUE, 0.15}
    };

    BadBobAdjuster(TaxCalculatorV5 taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    double getAdjustment() {
        return class1Adjustment() + getClass2BadbobAdjustment();
    }

    double class1Adjustment() {
        Map<String, Object> badbobs = (Map<String, Object>) taxCalculator.taxReturn.get("badbobs");
        int[] class1arr = (int[]) badbobs.get("class1");
        int class1 = 0;
        for (int b : class1arr) class1 += b;
        return class1 / 2.0;
    }

    double getClass2BadbobAdjustment() {
        Map<String, Object> badbobs = (Map<String, Object>) taxCalculator.taxReturn.get("badbobs");
        int[] class2arr = (int[]) badbobs.get("class2");
        int class2 = 0;
        for (int b : class2arr) class2 += b;

        double rate = getClass2Rate(class2);
        return rate * taxCalculator.totalIncome;
    }

    double getClass2Rate(int class2) {
        for (double[] row : class2Table) {
            if (class2 < row[0]) {
                return row[1];
            }
        }
        return 0; // fallback, should never hit due to Double.MAX_VALUE row
    }
}

public class TaxTestVersions{
    public static void main(String[] args) {
        TaxCalculatorV5 calc = new TaxCalculatorV5();
        Map<String, Object> taxReturn = makeReturn(20000, null, new int[]{10000});
        double result = calc.getTax(taxReturn);
        System.out.println("Result (BEFORE FIX): " + result); // Expected 0, got -9000!
    }

    static Map<String, Object> makeReturn(int salary, int[] class1, int[] class2) {
        Map<String, Object> income = new HashMap<>();
        income.put("salary", salary);
        Map<String, Object> badbobs = new HashMap<>();
        badbobs.put("class1", class1 != null ? class1 : new int[]{});
        badbobs.put("class2", class2 != null ? class2 : new int[]{});
        Map<String, Object> taxReturn = new HashMap<>();
        taxReturn.put("income", income);
        taxReturn.put("badbobs", badbobs);
        return taxReturn;
    }
}
