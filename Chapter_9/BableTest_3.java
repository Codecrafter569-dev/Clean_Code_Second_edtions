import java.util.Map;
import java.util.HashMap;
class TaxCalculator {
    private Map<String, Object> taxReturn;

    public TaxCalculator(Map<String, Object> taxReturn) {
        this.taxReturn = taxReturn;
    }

    public double getTax() {
    Map<String, Integer> income = (Map<String, Integer>) taxReturn.get("income");
    int totalIncome = income.get("salary");
    double tax = totalIncome * 0.15;
    double afterTaxIncome = totalIncome - tax;
    if (afterTaxIncome < 30000) {
        return totalIncome - 30000;
    } else {
        return tax;
    }
}

}

public class BableTest_3{
  public static void main(String args[]){
    testNoAfterTaxIncomeLessThan30K();
  }
  static void testNoAfterTaxIncomeLessThan30K() {
    Map<String, Object> tr1 = makeReturn(30001);
    TaxCalculator calc1 = new TaxCalculator(tr1);
    assertEqual(1, calc1.getTax());

    Map<String, Object> tr2 = makeReturn(35000);
    TaxCalculator calc2 = new TaxCalculator(tr2);
    assertEqual(5000, calc2.getTax());
}

static Map<String, Object> makeReturn(int salary) {
    Map<String, Object> taxReturn = new HashMap<>();
    Map<String, Integer> income = new HashMap<>();
    income.put("salary", salary);
    taxReturn.put("income", income);
    return taxReturn;
}

  static void assertEqual(double expected, double actual) {
        if (expected == actual) {
            System.out.println("PASS: expected " + expected + ", got " + actual);
        } else {
            System.out.println("FAIL: expected " + expected + ", got " + actual);
        }
    }
}