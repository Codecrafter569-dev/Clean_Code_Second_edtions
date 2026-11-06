import java.util.Map;
import java.util.HashMap;
class TaxCalculator {
    private Map<String, Object> taxReturn;

    public TaxCalculator(Map<String, Object> taxReturn) {
        this.taxReturn = taxReturn;
    }

    public double getTax() {
        return 0; // deliberately wrong — proves the test can fail
    }
}

public class BobaliaTaxTests_1{
  public static void main(String args[]){
    testSimpleCase();
  }
  static void testSimpleCase(){
    Map<String,Object> taxReturn = new HashMap<>();
    Map<String,Object> income = new HashMap<>();
    income.put("salary",50000);
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