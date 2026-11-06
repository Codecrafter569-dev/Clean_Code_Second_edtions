public class LargeOrderReporterTest{
  private static final int LARGE_ORDE_RREPORTER = 10;
  
  public void printLargeOrder(int[] orderAmounts){
    for(int amount : orderAmounts){
      if(amount > LARGE_ORDE_RREPORTER){
        System.out.println("Large order :"+amount);
      }
    }
  }
  public static void main(String args[]){
    int[] orders = {1,2,3,4,5,10,20,30,40,50};
    new LargeOrderReporterTest().printLargeOrder(orders);
  }
}