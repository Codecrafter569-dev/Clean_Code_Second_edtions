public class OrderCalculator{
  public double add(double a , double b){
    return a + b;
  }
  public double subtract(double a , double b){
    return a - b;
  }
  public static void main(String[] args){
    OrderCalculator calc = new OrderCalculator();
    System.out.println(calc.add(20,40));
    System.out.println(calc.subtract(30,10));
    
  }
}