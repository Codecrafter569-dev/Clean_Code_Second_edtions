public class VideoRental_2Test_2{
  public void processOrder(){
    int total = calculateTotal(20,40);
    System.out.println("Total :"+total);
  }
  private int calculateTotal(int a , int b){
    return a + b;
  }
  public static void main(String args[]){
    new VideoRental_2Test_2().processOrder();
  }
}