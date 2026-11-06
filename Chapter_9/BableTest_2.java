import java.util.Map;
import java.util.HashMap;
class TaxCalculator {
    private Map<String, Object> taxReturn;

    public TaxCalculator(Map<String, Object> taxReturn) {
        this.taxReturn = taxReturn;
    }

    public double getTax() {
         Map<String,Integer> income = (Map<String,Integer>) taxReturn.get("income");
         int totalIncome = income.get("salary");
         if(totalIncome > 30000){
           return totalIncome * 0.15;
         }
         return 0;
    }
}

public class BableTest_2{
  public static void main(String args[]){
    testSimpleCase();
  }
  static void testSimpleCase(){
    Map<String,Object> taxReturn = new HashMap<>();
    Map<String,Object> income = new HashMap<>();
    income.put("salary",30000);
    taxReturn.put("income",income);
    
    TaxCalculator calc = new TaxCalculator(taxReturn);
    assertEqual(7500,calc.getTax());
    
  }
  static void assertEqual(double expected, double actual) {
        if (expected == actual) {
            System.out.println("PASS: expected " + expected + ", got " + actual);
        } else {
            System.out.println("FAIL: expected " + expected + ", got " + actual);
        }
    }
}