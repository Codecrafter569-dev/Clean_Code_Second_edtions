import java.util.*;
class TaxCalculator{
  double getTax(Map<String,Object> taxReturn){
    int totalIncome = (int) ((Map<String, Object>) taxReturn.get("income")).get("salary");
    double tax = totalIncome * 0.15;
    double afterTaxIncome = totalIncome  - tax;
    if(afterTaxIncome < 30000){
      tax = totalIncome - 30000;
    }
    
    int[] class1 = (int[]) ((Map<String,Object>) taxReturn.get("badbobs")).get("class1");
    int sum = 0;
    for(int b : class1) sum += b;
    tax += sum / 2.0;
    return tax;
  }
}
public class TaxCalculatorMessy_1{
  public static void main(String args[]){
    static TaxCalculator calc = new TaxCalculator();

        check("Under 1001 badbobs", 7500, calc.getTax(makeReturn(50000, null, new int[]{400, 600})));
        check("Under 10001 badbobs", 10000, calc.getTax(makeReturn(50000, null, new int[]{10000})));
        check("Under 50001 badbobs", 12500, calc.getTax(makeReturn(50000, null, new int[]{10000, 40000})));
        check("Over 50000 badbobs", 15000, calc.getTax(makeReturn(50000, null, new int[]{10000, 40000, 1000})));
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

    static void check(String name, double expected, double actual) {
        System.out.println(name + " => Expected:" + expected + " Actual:" + actual +
            " [" + (expected == actual ? "PASS" : "FAIL") + "]");
  }
}