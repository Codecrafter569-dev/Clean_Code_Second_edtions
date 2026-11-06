public class InventoryTestDriveGood{
  private int stock;
  public InventoryTestDriveGood(int initialStock){
    this.stock = initialStock;
  }
  public void restock(int quantity){
    this.stock += quantity;
  }
  public void sell(int quantity){
    stock = Math.max(0,stock - quantity);
  }
  
  public int getStock(){
    return stock;
  }
  public static void main(String[] args){
    InventoryTestDriveGood inventoey = new InventoryTestDriveGood(300);
    inventoey.restock(500);
    inventoey.sell(20);
    inventoey.sell(40);
    System.out.println("Final stock :"+inventoey.getStock());
  }
}