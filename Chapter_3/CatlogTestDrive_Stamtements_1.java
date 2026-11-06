import java.util.ArrayList;
import java.util.List;
interface CatlogItem{
  boolean isEligibleForDiscount(int days);
  int getUnitPrice();
  double getTaxRate();
  String getName();
}
class SmallRoom implements CatlogItem{
  public String getName(){
    return "SMALL_ROOM";
  }
  public boolean isEligibleForDiscount(int days){ return days == 5;}
  public int getUnitPrice(){return 100;}
  public double getTaxRate(){return 0.05;}
}

class LargeRoom implements CatlogItem{
  public String getName(){
    return "LARGE_ROOM";
  }
  public boolean isEligibleForDiscount(int days){ return days == 5;}
  public int getUnitPrice(){return 150;}
  public double getTaxRate(){return 0.05;}
}

class Projector implements CatlogItem{
  public String getName(){ return "PROJECTOR";}
  public boolean isEligibleForDiscount(int days){return false;}
  public int getUnitPrice(){return 50;}
  public double getTaxRate(){return 0.05;}
}

class Coffe implements CatlogItem{
    public String getName(){
   return "COFFE";
    }
public boolean isEligibleForDiscount(int days){return false;}
public int getUnitPrice(){return 10;}
public double getTaxRate(){return 0;}
}

class Cookies implements CatlogItem{
  public String getName(){
    return "COOKIES";
  }
  public boolean isEligibleForDiscount(int days){
    return false;
  }
  public int getUnitPrice(){ return 15;}
  public double getTaxRate(){return 0;}
}
record RentalItem(String type , int days , int unitPrice , int price , int tax){
  
}

class ItemList{
  private List<RentalItem> items = new ArrayList<>();
  
  public void add(CatlogItem item , int days, int unitPrice , int price , int tax){
    items.add(new RentalItem(item.getName(),days,unitPrice,price,tax));
  }
  
  public RentalItem[] getItems(){
    boolean largeRoomFiveDays = items.stream().anyMatch(
      item  -> item.type().equals("LARGE_ROOM")  && item.days() == 5
      );
      boolean coffeeFiveDays = items.stream().anyMatch(
        item -> item.type().equals("COFFE") && item.days() == 5
        );
        
        if(largeRoomFiveDays  && coffeeFiveDays){
          items.add(new RentalItem("COOKIES",5,0,0,0));
        }
        
        return items.toArray(new RentalItem[0]);
  }
}

class Statement{
  private ItemList items = new ItemList();
  private int subtotal = 0;
  private int tax = 0;
  
  public void rent(CatlogItem item , int days){
    int unitPrice = item.getUnitPrice();
    int price  = calculatePrice(item,days,unitPrice);
    int thisTax = (int) Math.round(price*item.getTaxRate());
    items.add(item,days,unitPrice,price,thisTax);
    subtotal += price;
    tax += thisTax;
  }
  
  private int calculatePrice(CatlogItem  item,int days , int unitPrice){
    boolean eligibleForDiscount = item.isEligibleForDiscount(days);
    int price = unitPrice * days;
    if(eligibleForDiscount){
      price = (int )Math.round(price*0.9);
    }
    return price;
  }
  public RentalItem[] getItems(){
    return items.getItems();
  }
  public int getSubtotal(){
    return subtotal;
  }
  public int getTax(){return tax;}
  public int getTotal(){
    return subtotal+tax;
  }
}
public class CatlogTestDrive_Stamtements_1 {
  public static void main(String[] args) {
    Statement statement = new Statement();

        statement.rent(new LargeRoom(), 5);
        statement.rent(new Coffe(), 5);

        System.out.println("Rental Statement:");
        System.out.println("-----------------");
        for (RentalItem item : statement.getItems()) {
            System.out.printf("%-12s days=%d unitPrice=%d price=%d tax=%d%n",
                    item.type(), item.days(), item.unitPrice(), item.price(), item.tax());
        }

        System.out.println("-----------------");
        System.out.println("Subtotal: " + statement.getSubtotal());
        System.out.println("Tax:      " + statement.getTax());
        System.out.println("Total:    " + statement.getTotal());
  }
}