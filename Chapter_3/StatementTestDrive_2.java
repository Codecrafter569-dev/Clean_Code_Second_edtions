import java.util.ArrayList;
import java.util.List;

public class StatementTestDrive_2{
  
  public enum CatalogItem { SMALL_ROOM , LARGE_ROOM,PROJECTOR,COFFEE,COOKIES}
  
  public record RentalItem(CatalogItem type , int days , int unitPrince , int price , int tax ){
    
  }
  
  public  record  Totals(int subtotal,int tax){
    
  }
  
  private String customerName;
  private int subtotal = 0;
  private int tax = 0;
  private List<RentalItem> items = new ArrayList<>();
  
  
  public StatementTestDrive_2(String customerName){
    this.customerName = customerName;
  }
  
  public void rent(CatalogItem item , int days){
    int unitPrince = switch(item){
      case SMALL_ROOM  -> 100;
      case LARGE_ROOM  -> 150;
      case PROJECTOR  -> 50;
      case COFFEE  -> 10;
      case COOKIES  -> 15;
    };
    
    boolean eligibleForDiscount  = switch(item){
      case SMALL_ROOM , LARGE_ROOM  -> days == 5;
      case PROJECTOR , COFFEE  , COOKIES  -> false;
    };
    
    int price =  unitPrince * days;
    if(eligibleForDiscount)  price = (int) Math.round(price * .9);
    
    subtotal  += price;
    
    int thisTax = switch(item){
      case SMALL_ROOM , LARGE_ROOM , PROJECTOR  -> (int) Math.round(price * .05);
      case COFFEE  , COOKIES   -> 0;
      
    };
    tax += thisTax;
    items.add(new RentalItem(item , days , unitPrince , price , thisTax));
  }
  
  public RentalItem[]  getItems(){
    List<RentalItem> items = new ArrayList<>(this.items);
    
    boolean largestRoomFiveDays = items.stream().anyMatch(
      item -> item.type()  == CatalogItem.LARGE_ROOM  && item.days() == 5);
      
    boolean coffeeFiveDays = items.stream().anyMatch(
      item  -> item.type()  == CatalogItem.COFFEE  && item.days() == 5);
      
      if(largestRoomFiveDays  && coffeeFiveDays){
        items.add(new RentalItem(CatalogItem.COOKIES , 5,0,0,0));
      }
      return items.toArray(new RentalItem[0]);
  }
  
   public String getCustomerName(){
     return customerName;
   }
   
   public Totals  getTotals(){
     return new Totals(subtotal,tax);
   }
  public static void main(String[] args) {
    
    
    StatementTestDrive_2  statements = new StatementTestDrive_2("Alex johnson");
    
    statements.rent(CatalogItem.LARGE_ROOM  , 4);
    statements.rent(CatalogItem.COFFEE , 5);
    statements.rent(CatalogItem.PROJECTOR , 5);
    
    
    System.out.println("Customer : "+statements.getCustomerName());
    System.out.println();
    
    
    for(RentalItem  item : statements.getItems()){
      System.out.println(item.type()
      +"  |  days ="+item.days()
      +"  | unitPrince ="+item.unitPrince()
      +"  | price ="+item.price()
      +"  | tax ="+ item.tax()
      );
    }
    
    Totals totals = statements.getTotals();
    System.out.println();
    System.out.println("Subtotal  :"+totals.subtotal());
    System.out.println("Tax :"+totals.tax());
    System.out.println("Totals :"+(totals.subtotal()+totals.tax()));
    
  }
}