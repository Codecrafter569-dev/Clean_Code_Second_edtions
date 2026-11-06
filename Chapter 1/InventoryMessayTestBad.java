public class InventoryMessayTestBad{
  int stock = 100;
  public void update(int n,boolean add){
    if(add) stock = stock + n;
    else stock = stock - n;
    if(stock < 0) stock = 0;
    System.out.println(stock);
  }
  
  public static void main(String[] args){
    InventoryMessayTestBad inv = new InventoryMessayTestBad();
    inv.update(50,true);
    inv.update(200,false);
  }
}