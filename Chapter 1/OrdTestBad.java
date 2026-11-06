public class OrdTestBad{
  public double calc(double a,double b,int t){
    if(t == 1) return a+b;
    else if(t == 2) return a - b;
    else return 0;
  }
  
  public static void main(String[] args){
    OrdTestBad b1 = new OrdTestBad();
    System.out.println(b1.calc(10,29,1));
    System.out.println(b1.calc(20,40,2));
  }
}