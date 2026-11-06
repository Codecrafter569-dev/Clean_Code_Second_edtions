public class firstprogram_1{
  public static String classifyNumber(int n){
    if(n < 0){
      return "Negative";
    }else if(n == 0){
      return "zero";
    }else{
      int sum = 0;
      int i = 1;
      while(i <= n){
        sum += i;
        i++;
      }
      return "Positive : sum 1 to "+n+" = "+sum;
    }
  }
  public static void main(String args[]){
    System.out.println(classifyNumber(-5));
    System.out.println(classifyNumber(0));
    System.out.println(classifyNumber(30))
  }
}