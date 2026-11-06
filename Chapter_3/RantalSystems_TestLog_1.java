
public class RantalSystems_TestLog_1 {
  
  public enum CatalogItem{
    SMALL_ROOM,
        LARGE_ROOM,
        PROJECTOR,
        COFFEE,
        COOKIES
    
  };
  
  public record RentalItem(
    CatalogItem item,
    int days,
    int unitPrice,
    int price,
    int tax
    ){}
    
    private final java.util.List<RentalItem> items = new java.util.ArrayList<>();
    private int subtotal = 0;
    private int tax = 0;
//#43c3d1    
    public void rent(CatalogItem item , int days){
      int unitPrice = getUntiPrice(item);
      int price = calculatePrice(item,days,unitPrice);
      int thisTax = getTax(item,price);
      
      
      items.add(new RentalItem(item,days,unitPrice , price , thisTax));
      
      subtotal += price;
      tax += thisTax;
    }
    
private int getUntiPrice(CatalogItem item){
  return switch(item){
    case SMALL_ROOM  -> 100;
    case LARGE_ROOM  -> 150;
    case PROJECTOR  -> 50;
    case COFFEE  -> 10;
    case COOKIES -> 15;
  };
}

private int calculatePrice(CatalogItem  item , int days , int unitPrice){
  boolean eligibleForDiscount = isEligibleForDiscount(item,days);
  int price = unitPrice * days;
  if(eligibleForDiscount) price = (int) Math.round(price * .9);
  return price;
}

private boolean isEligibleForDiscount(CatalogItem item , int days){
  return switch(item){
    case SMALL_ROOM , LARGE_ROOM  -> days == 5;
    case PROJECTOR , COFFEE , COOKIES  -> false;
  };
}

private int getTax(CatalogItem item , int price){
  return switch(item){
    case SMALL_ROOM , LARGE_ROOM , PROJECTOR  -> (int) Math.round(price * .05);
    
    case COFFEE ,COOKIES  -> 0;
  };
}

public int getSubtotal(){
  return subtotal;
}

public int getTax(){
  return tax;
}

public int getTotal(){
  return subtotal + tax;
}
public java.util.List<RentalItem> getItems(){
  return items;
}
  public static void main(String[] args) {
    RantalSystems_TestLog_1 system = new RantalSystems_TestLog_1();
    
    system.rent(CatalogItem.SMALL_ROOM,5);
    system.rent(CatalogItem.PROJECTOR , 3);
    system.rent(CatalogItem.COFFEE,10);
    system.rent(CatalogItem.COOKIES ,4);
    system.rent(CatalogItem.LARGE_ROOM , 2);
    
    for(RentalItem ri : system.getItems()){
      System.out.println(ri.item() + " | days=" + ri.days()
                    + " | unitPrice=" + ri.unitPrice()
                    + " | price=" + ri.price()
                    + " | tax=" + ri.tax());
                    
                    
    }
    
    System.out.println("Subtotal: " + system.getSubtotal());
        System.out.println("Tax: " + system.getTax());
        System.out.println("Total: " + system.getTotal());
        
        
    
  }
}