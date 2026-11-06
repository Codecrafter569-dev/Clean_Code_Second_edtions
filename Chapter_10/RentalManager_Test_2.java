public class RentalManager_Test_2{
  private int totalAmount = 0;
  private int renterPoints = 0;
  
  void clearTotals(){
    totalAmount = 0;
    renterPoints = 0;
  }
  void incements(int a,int b){
    totalAmount += a;
    renterPoints += b;
  }
  public static void main(String args[]){
    RentalManager_Test_2 rm = new RentalManager_Test_2();
    rm.clearTotals();
    System.out.println("Amount :"+rm.totalAmount +", Points :"+rm.renterPoints);
    
    for(int i=0; i < 20 ;i++){
      rm.incements(i,i*2+5);
    }
    System.out.println("Amount :"+rm.totalAmount +", Points :"+rm.renterPoints);
    
  }
}