import java.util.*;
class TaxCalculatorV4{
  private Map<String,Object> taxReturn;
  private double totalIncome;
  
  double getTax(Map<String,Object> taxReturn){
    this.taxReturn = taxReturn;
    double tax = determineBaseTax();
    tax += determineBadbobAdjustments();
    return tax;
  }
  double determineBadbobAdjustments(){
    Map<String,Object> badbobs = (Map<String,Object>) taxReturn.get("badbobs");
    int[] class1arr = (int[]) badbobs.get("class1");
    int class1 = 0;
    for(int b : class1arr) class1 += b;
    double class1Adjustments = class1 / 2.0;
    
    int[] class2arr = (int[]) badbobs.get("class2");
    int class2 = 0;
    for(int b : class2arr) class2 += b;
    
    double class2Adjustments;
    if(class2 < 1001){
      class2Adjustments = 0;
      
    }else if(class2 < 10001){
      class2Adjustments = totalIncome * 0.05;
    }else if(class2 < 50001){
      class2Adjustments = totalIncome * 0.1;
    }else{
      class2Adjustments = totalIncome * 0.15;
    }
    return class1Adjustments + class2Adjustments;
  }
  double determineBaseTax(){
    totalIncome = (int) ((Map<String, Object>) taxReturn.get("income")).get("salary");
    double tax = totalIncome * 0.15;
    double afterTaxIncome = totalIncome - tax;
    if(afterTaxIncome < 30000){
      tax = totalIncome - 30000;
    }
    return tax;
  }
  
}
public class BadbodTests_1{
  static TaxCalculatorV4 calc = new TaxCalculatorV4();
  
  public static void main(String args[]){
    check("Under 1001 badbobs",7500,calc.getTax(makeReturn(50000,null,new int[]{400,600})));
    check("Under 10001 badbobs", 10000, calc.getTax(makeReturn(50000, null, new int[]{10000})));
        check("Under 50001 badbobs", 12500, calc.getTax(makeReturn(50000, null, new int[]{10000, 40000})));
        check("Over 50000 badbobs", 15000, calc.getTax(makeReturn(50000, null, new int[]{10000, 40000, 1000})));
  }
  
  static Map<String, Object> makeReturn(int salary, int[] class1 , int[] class2){
    Map<String,Object> income = new HashMap<>();
    income.put("salary",salary);
    
    Map<String,Object> badbobs = new HashMap<>();
    badbobs.put("class1",class1 != null ? class1 : new int[]{});
    badbobs.put("class2",class2 != null ? class2 : new int[]{});
    
    Map<String, Object> taxReturn = new HashMap<>();
    taxReturn.put("income",income);
    taxReturn.put("badbobs",badbobs);
    return taxReturn;
  }
  
  static void check(String name, double expected, double actual){
    System.out.println(name+" => Expected:"+expected+" Actual:"+actual+"["+(expected == actual ? "PASS" : "FAIL")+"]");
  }
}