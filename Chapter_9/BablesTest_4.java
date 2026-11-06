import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class TaxCalculator {
    private Map<String, Object> taxReturn;

    public TaxCalculator(Map<String, Object> taxReturn) {
        this.taxReturn = taxReturn;
    }

    public double getTax() {
    Map<String, Integer> income = (Map<String, Integer>) taxReturn.get("income");
    int totalIncome = income.get("salary");
    double tax = totalIncome * 0.15;

    Map<String, List<Integer>> badbobs = (Map<String, List<Integer>>) taxReturn.get("badbobs");
    List<Integer> class1 = badbobs.get("class1");
    int class1Total = 0;
    for (int points : class1) {
        class1Total += points;
    }
    tax += class1Total * 0.50;   // class 1 badbobs taxed at 50%

    double afterTaxIncome = totalIncome - tax;
    if (afterTaxIncome < 30000) {
        return totalIncome - 30000;
    } else {
        return tax;
    }
}


}

public class BablesTest_4{
  public static void main(String args[]){
    //testNoAfterTaxIncomeLessThan30K();
    
    testClass1Badbobs();
  }
/*  static void testNoAfterTaxIncomeLessThan30K() {
    Map<String, Object> tr1 = makeReturn(30001);
    TaxCalculator calc1 = new TaxCalculator(tr1);
    assertEqual(1, calc1.getTax());

    Map<String, Object> tr2 = makeReturn(35000);
    TaxCalculator calc2 = new TaxCalculator(tr2);
    assertEqual(5000, calc2.getTax());
}

*/

static void testClass1Badbobs() {
    Map<String, Object> taxReturn = makeReturn(50000, 100);
    TaxCalculator calc = new TaxCalculator(taxReturn);
    assertEqual(7550, calc.getTax());
}

static Map<String, Object> makeReturn(int salary, int badbobsClass1) {
    Map<String, Object> taxReturn = new HashMap<>();

    Map<String, Integer> income = new HashMap<>();
    income.put("salary", salary);   // default-friendly
    taxReturn.put("income", income);

    List<Integer> class1 = new ArrayList<>();
    if (badbobsClass1 > 0) {
        class1.add(badbobsClass1);
    }
    Map<String, List<Integer>> badbobs = new HashMap<>();
    badbobs.put("class1", class1);
    taxReturn.put("badbobs", badbobs);

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