import java.util.ArrayList;
import java.util.List;
interface CatalogItem{
  int getDiscountPrice(int days);
  int getUnitPrice();
  double getTaxRate();
  String getName();
}
interface Bonus{
  void checkAndAdd(List<RentalItem> items , List<RentalItem> bonusItems);
}
record RentalItem(String type , int days , int unitprice , int price , int tax){
  
}

class SmallRoom implements CatalogItem{
  public String getName(){ return "SMALL_ROOM";}
  public int getDiscountPrice(int days){
    double discountRate = (days == 5) ? 0.9 : 1.0;
    return (int) Math.round(getUnitPrice() * days * discountRate);
  }
  public int getUnitPrice(){return 100;}
  public double getTaxRate(){return 0.05;}
}

class LargeRoom implements CatalogItem{
  public String getName(){
    return "LARGE_ROOM";
  }
  public int getDiscountPrice(int days){
    double discountRate = (days == 5) ? 0.9 : 1.0;
    return (int) Math.round(getUnitPrice()*days*discountRate);
  }
  public int getUnitPrice(){ return 150;}
  public double getTaxRate(){ return 0.05;}
}
class Coffee implements CatalogItem{
  public int getDiscountPrice(int days ){
    return getUnitPrice()*days;
  }
  public int getUnitPrice(){return 10;}
  public double getTaxRate(){return 0;}
  public String getName(){return "COFFEE";}
}

class Cookies implements CatalogItem{
  public int getDiscountPrice(int days){
    return getUnitPrice()*days;
  }
  public int getUnitPrice(){return 15;}
  public double getTaxRate(){ return 0;}
  public String getName(){return "COOKIES";}
}

class cookiesBonus implements Bonus{
  public void checkAndAdd(List<RentalItem> items , List<RentalItem> bonusItems){
    boolean largeRoomFiveDays = items.stream().anyMatch(
      item -> item.type().equals("LARGE_ROOM")  && item.days() == 5);
    
    boolean coffeeFiveDays = items.stream().anyMatch(
      item -> item.type().equals("COFFEE") && item.days() == 5
      );
      if(largeRoomFiveDays && coffeeFiveDays){
        bonusItems.add(new RentalItem("COOKIES",5,0,0,0));
      }
  }
}
class RentalReceipt{
  private List<RentalItem> items = new ArrayList<>();
  
  public void add(RentalItem item){
    items.add(item);
  }
  
  public RentalItem[] finalize(List<Bonus> bonuses){
    List<RentalItem> finalItems = new ArrayList<>(this.items);
    finalItems.addAll(addBonuses(bonuses));
    return finalItems.toArray(new RentalItem[0]);
  }
  
  private List<RentalItem> addBonuses(List<Bonus> bonuses){
    List<RentalItem> bonusItems  = new ArrayList<>();
    
    for(Bonus bonus : bonuses){
      bonus.checkAndAdd(items,bonusItems);
    }
    return bonusItems;
  }
}


class RentalOrder{
  public record Totals(int subtotal,int tax){
    
  }
  
  private String customerName;
  private int subtotal = 0;
  private int tax = 0;
  private RentalReceipt receipt = new RentalReceipt();
  private List<Bonus> bonuses = new ArrayList<>();
  
  public RentalOrder(String customerName){
    this.customerName = customerName;
  }
  
  public void addBonus(Bonus bonus){
    bonuses.add(bonus);
  }
  
  public void rent(CatalogItem item , int days){
    int unitprice = item.getUnitPrice();
    int price = item.getDiscountPrice(days);
    int thisTax = (int) Math.round(price * item.getTaxRate());
    
    receipt.add(new RentalItem(item.getName(),days , unitprice , price , thisTax));
    subtotal += price;
    tax += thisTax;
  }
  public RentalItem[] getRecept(){
    return receipt.finalize(bonuses);
  }
  public String getCustomerName(){
    return customerName;
  }
  
  public Totals getTotals(){
    return new Totals(subtotal,tax);
  }
}


public class FinalVersionTestCatlogTestDrive_3 {
  public static void main(String[] args) {
    RentalOrder order = new RentalOrder("Codecrafter");
    order.addBonus(new cookiesBonus());
    order.rent(new LargeRoom(),5);
    order.rent(new Coffee(),5);
    
    System.out.println("Customer : "+order.getCustomerName());
    System.out.println("----------------------------------------");
    for(RentalItem item : order.getRecept()){
      System.out.printf("%-12s days=%d unitPrice=%d price=%d tax=%d%n",
                    item.type(), item.days(), item.unitprice(), item.price(), item.tax());
    }
    
    RentalOrder.Totals  totals = order.getTotals();
    System.out.println("----------------------------------------");
    System.out.println("Subtotal  :"+totals.subtotal());
    System.out.println("Tax :"+totals.tax());
    System.out.println("Total :"+(totals.subtotal()+totals.tax()));
  }
}